package com.b2w.starwars_api.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.b2w.starwars_api.GlobalVariables;
import com.b2w.starwars_api.consuming.swapi.movie.MovieResponse;
import com.b2w.starwars_api.consuming.swapi.planet.PlanetResponse;

@Component
public class SwapiService {

    public List<MovieResponse> fetchMoviesByPlanetName(String planetName) {
        String URL = GlobalVariables.SW_API_DOMAIN + "/api/planets/?search={search}";
        List<MovieResponse> movies = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        try {

            ResponseEntity<PlanetResponse> result = restTemplate.getForEntity(URL, PlanetResponse.class, planetName);
            List<String> filmsListUrls = result.getBody().getResults().get(0).getFilms();

            if (!filmsListUrls.isEmpty()) {
                for (String filmURL : filmsListUrls) {
                    ResponseEntity<MovieResponse> movieResult = restTemplate
                            .getForEntity(filmURL.replace("http", "https"), MovieResponse.class);

                    movies.add(movieResult.getBody());
                }
            }
        } catch (RestClientException e) {
            System.out.println("Some Error Ocurred " + e.getMessage());
            System.out.println("Some Error Ocurred " + e.getLocalizedMessage());
        };

        return movies;
    }
}