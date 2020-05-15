package com.b2w.starwars_api.consuming.swapi.movie;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse  extends MovieTemplate{
    public MovieResponse(String title, String director, String producer, String release_date, String episode_id) {
        super(title, director, producer, release_date, episode_id);
    }
    public MovieResponse() {
    }
    
}