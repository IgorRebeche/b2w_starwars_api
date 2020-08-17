package com.b2w.starwars_api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import com.b2w.starwars_api.consuming.swapi.movie.MovieResponse;
import com.b2w.starwars_api.models.Planet;
import com.b2w.starwars_api.responses.Response;
import com.b2w.starwars_api.services.PlanetService;
import com.b2w.starwars_api.services.SwapiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private SwapiService swapiService;

    @GetMapping("/hello")
    public String sayHello(HttpServletResponse response) {
        return "hello";
    }

    @GetMapping(value = "/planets/{id}")
    public ResponseEntity<Response<Planet>> findById(@PathVariable(name = "id") String id, @RequestParam String name) {
        Planet planet = planetService.findById(id);

        if(name != null){
            planet = planetService.findByName(name);
        }

        if(planet == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(new Response<>(planetService.findById(id)));
    }

    @GetMapping(value = "/planets")
    public ResponseEntity<Response<List<Planet>>> list() {
        return ResponseEntity.ok(new Response<>(planetService.listPlanets()));
    }

    @PostMapping(value = "/planets")
    public ResponseEntity<Response<Planet>>  create(@RequestBody Planet planet) {
        List<MovieResponse> movies = swapiService.fetchMoviesByPlanetName(planet.getName());
        
        if (!movies.isEmpty()) {
            planet.setMovies(movies);
        }
        planetService.createPlanet(planet);
        URI location = URI.create(String.format("/planets/%s", planet.getName()));
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/planets/{id}")
    public ResponseEntity<Response<Integer>> removePlanet(@PathVariable(name = "id") String id) {
        
        if (planetService.removePlanetById(id)) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.badRequest().body(new Response<>(0));
    }

}
