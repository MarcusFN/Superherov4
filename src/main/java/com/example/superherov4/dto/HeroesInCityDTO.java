package com.example.superherov4.dto;

public class HeroesInCityDTO {
    private String city;
    private String superheroName;

    public HeroesInCityDTO( String city, String superheroName) {
        this.city = city;
        this.superheroName = superheroName;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
