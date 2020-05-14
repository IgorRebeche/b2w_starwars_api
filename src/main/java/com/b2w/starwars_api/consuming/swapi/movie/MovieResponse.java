package com.b2w.starwars_api.consuming.swapi.movie;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse {
    List<MovieTemplate> results;
    
}