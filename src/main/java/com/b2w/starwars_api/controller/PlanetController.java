package com.b2w.starwars_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.b2w.starwars_api.models.Planet;
import com.b2w.starwars_api.services.PlanetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/api")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping(value="/planets/{id}")
    public ResponseEntity<Planet> findById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(planetService.findById(id));
    }

    @PostMapping(value = "/planets")
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        return ResponseEntity.ok(planetService.createPlanet(planet));
    }

    @DeleteMapping(value = "/planets")
    public ResponseEntity<Integer> removePlanet(@RequestParam String id){
        planetService.removePlanet(id);
        return ResponseEntity.ok(1);
    }


    
}
