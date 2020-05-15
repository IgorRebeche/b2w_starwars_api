package com.b2w.starwars_api.controller;

import java.util.ArrayList;
import java.util.List;

import com.b2w.starwars_api.consuming.swapi.movie.MovieResponse;
import com.b2w.starwars_api.models.Planet;
import com.b2w.starwars_api.responses.Response;
import com.b2w.starwars_api.services.SwapiService;
import com.b2w.starwars_api.services.implemenations.PlanetServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlanetControllerTest {
    
    @InjectMocks
    PlanetController planetController;

    @Mock
    SwapiService swapiService;

    @Mock
    PlanetServiceImpl planetService;

    private List<Planet> planetList;

    @Test
    public void shouldFetchAllPlanets() {
        planetList = new ArrayList<>();
        planetList.add(new Planet("1", "Teste2", "arido", "arenoso"));
        planetList.add(new Planet("2", "Teste3", "arido", "arenoso"));

        when(planetService.listPlanets()).thenReturn(planetList);

        ResponseEntity<Response<List<Planet>>> actualList = planetController.list();

        assertThat(actualList.getBody().getData().size()).isEqualTo(2);

    }

    @Test
    public void shouldFetchById() {
        Planet planet = new Planet("1", "Teste2", "arido", "arenoso");

        when(planetService.findById(planet.getId())).thenReturn(planet);

        ResponseEntity<Response<Planet>> actualList = planetController.findById(planet.getId(), null);

        assertThat(actualList.getBody().getData().getId()).isEqualTo(planet.getId());
    }

    @Test
    public void shouldRemoveById() {
        Planet planet = new Planet("1", "Teste2", "arido", "arenoso");

        when(planetService.removePlanetById(planet.getId())).thenReturn(true);

        ResponseEntity<Response<Integer>> response = planetController.removePlanet(planet.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    public void shouldCreatePlanet() {
        Planet planet = new Planet("1", "Teste2", "arido", "arenoso");
        List<MovieResponse> movies = new ArrayList<>();
        movies.add(new MovieResponse("Filme Titulo", "director", "producer", "release_date", "episode_id"));

        when(planetService.createPlanet(planet)).thenReturn(planet);
        when(swapiService.fetchMoviesByPlanetName(planet.getName())).thenReturn(movies);

        ResponseEntity<Response<Planet>> response = planetController.create(planet);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}