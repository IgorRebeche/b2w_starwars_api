package com.b2w.starwars_api.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.b2w.starwars_api.models.Planet;
import com.b2w.starwars_api.repository.PlanetRepository;
import com.b2w.starwars_api.services.implemenations.PlanetServiceImpl;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlanetServiceTest {

    @InjectMocks
    private PlanetServiceImpl planetService;

    @Mock
    private PlanetRepository planetRepository;

    Planet planet = new Planet("1", "Dagobah", "murky", "swamp, jungles");

    @Test
    public void shouldListPlanets() {
        List<Planet> planetList = new ArrayList<>();
        planetList.add(planet);
        planetList.add(new Planet("2", "Tatooine", "arid", "desert"));

        when(planetRepository.findAll()).thenReturn(planetList);

        List<Planet> actualList = planetService.listPlanets();

        assertThat(actualList).isEqualTo(planetList);
    }

    @Test
    public void shouldFindById() {
        Planet planet = new Planet("1", "Dagobah", "murky", "swamp, jungles");

        when(planetRepository.findById(planet.getId())).thenReturn(Optional.of(planet));

        Planet actualPlanet = planetService.findById(planet.getId());

        assertThat(actualPlanet).isEqualTo(planet);
    }

    @Test
    public void shouldFindByName() {

        when(planetRepository.findByName(planet.getName())).thenReturn(Optional.of(planet));

        Planet actualPlanet = planetService.findByName(planet.getName());

        assertThat(actualPlanet).isEqualTo(planet);
    }

    @Test
    public void shouldRemovePlanet() {

        planetService.removePlanetById(planet.getId());

        verify(planetRepository, times(1)).deleteById(planet.getId());

    }

    @Test
    public void shouldCreatePlanet() {

        planetService.createPlanet(planet);

        verify(planetRepository, times(1)).save(planet);
    }

}