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
        String URL = "https://swapi.dev" + "/api/planets/";
        List<MovieResponse> movies = new ArrayList<>();

        Map<String, String> planetParams = new HashMap<String, String>();
        planetParams.put("name", planetName);

        RestTemplate restTemplate = new RestTemplate();
        try {
            // PlanetResponse planetResponse = restTemplate.getForObject(URL,
            // PlanetResponse.class);
            // ResponseEntity<PlanetResponse> res = restTemplate.getForEntity(URL,
            // PlanetResponse.class, planetParams);
            ResponseEntity<PlanetResponse> result = restTemplate.getForEntity(URL, PlanetResponse.class);
            List<String> filmsListUrls = result.getBody().getResults().get(0).getFilms();

            if (filmsListUrls.size() > 0) {
                for (String filmURL : filmsListUrls) {
                    MovieResponse movie = restTemplate.getForObject(filmURL, MovieResponse.class);
                    movies.add(movie);
                }
                return movies;
            }
        } catch (RestClientException e) {
            System.out.println("debug " + e.getMessage());
            System.out.println("debug " + e.getLocalizedMessage());
        }

        // MovieTemplate m = new MovieTemplate("title", "director", "producer",
        // "release_date", "episode_id");
        // movies.add(m);
        return null;
    }
    // Caso sim, Para cada filme, realizar uma chamada e atribuir ao template
}