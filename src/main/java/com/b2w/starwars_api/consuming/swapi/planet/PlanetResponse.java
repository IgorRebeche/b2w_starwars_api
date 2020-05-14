package com.b2w.starwars_api.consuming.swapi.planet;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetResponse {
    List<PlanetTemplate> results;

    public List<PlanetTemplate> getResults() {
        return results;
    }

    public void setResults(List<PlanetTemplate> results) {
        this.results = results;
    }

    
}