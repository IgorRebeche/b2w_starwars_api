package com.b2w.starwars_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class Planet {
    @Id
    String id;
    String name;
    String climate;

    public Planet(String id, String name, String climate) {
        this.id = id;
        this.name = name;
        this.climate = climate;
    }

    public Planet() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }
}
