package com.b2w.starwars_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.b2w.starwars_api.models.Planet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository planetRepository;
    Planet planet = new Planet("1", "Tatooine", "arido", "arenoso");

    @BeforeEach
    public void setup() {
        planetRepository.save(planet);
    }

    @Test
    public void shouldNotBeEmpty() {
        assertTrue(!planetRepository.findAll().isEmpty());
    }

    @Test
    public void shouldFindById() {
        Planet foundPlanet = planetRepository.findById(planet.getId()).orElseThrow();
        assertEquals(planet.getId(), foundPlanet.getId());
    }

    @Test
    public void shouldFindByName() {
        Planet foundPlanet = planetRepository.findByName(planet.getName()).orElseThrow();
        assertEquals(planet.getName(), foundPlanet.getName());
    }

    @Test
    public void shouldDelete() {
        Planet expectPlanet = new Planet("2", "Teste2", "arido", "arenoso");
        planetRepository.save(expectPlanet);
        assertEquals(planetRepository.findById(expectPlanet.getId()).orElseThrow().getId(), expectPlanet.getId());
        planetRepository.delete(expectPlanet);
        assertEquals(planetRepository.findById(expectPlanet.getId()).orElse(null), null);
    }

    @Test
    public void shouldCreate() {
        Planet expectPlanet = new Planet("3", "Teste3", "arido", "arenoso");
        planetRepository.save(expectPlanet);
        assertEquals(planetRepository.findById(expectPlanet.getId()).orElseThrow().getId(),
                Optional.of(expectPlanet).orElseThrow().getId());
    }

}