package com.b2w.starwars_api.consuming.swapi.movie;

public class MovieTemplate {
    private String title;
    private String director;
    private String producer;
    private String release_date;
    private String episode_id;

    public MovieTemplate(String title, String director, String producer, String release_date, String episode_id) {
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.episode_id = episode_id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
    }
}