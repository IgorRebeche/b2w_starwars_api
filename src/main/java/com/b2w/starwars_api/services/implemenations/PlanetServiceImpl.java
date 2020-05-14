package com.b2w.starwars_api.services.implemenations;

import java.util.List;

import com.b2w.starwars_api.models.Planet;
import com.b2w.starwars_api.repository.PlanetRepository;
import com.b2w.starwars_api.services.PlanetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public List<Planet> listPlanets() {
        return this.planetRepository.findAll();
    }

    @Override
    public Planet findByName(String name) {
        return null;
    }

    @Override
    public Planet findById(String id) {
            return this.planetRepository.findById(id).orElse(null);
    }

    @Override
    public void removePlanet(String id) {
        this.planetRepository.deleteById(id);
    }

    @Override
    public Planet createPlanet(Planet planet) {
        return this.planetRepository.save(planet);
    }
}
