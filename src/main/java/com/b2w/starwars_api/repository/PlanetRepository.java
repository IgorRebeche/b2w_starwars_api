package com.b2w.starwars_api.repository;

import com.b2w.starwars_api.models.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetRepository extends MongoRepository<Planet, String> {

}
