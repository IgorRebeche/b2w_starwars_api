package com.b2w.starwars_api.services;

import java.util.List;
import com.b2w.starwars_api.models.Planet;

public interface PlanetService {

    List<Planet> listPlanets();
    Planet findByName(String name);
    Planet findById(String id);
    boolean removePlanetById(String id);
    Planet createPlanet(Planet planet);


}
