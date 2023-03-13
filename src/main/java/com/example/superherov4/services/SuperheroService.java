package com.example.superherov4.services;

import com.example.superherov4.dto.CountSuperpowersDTO;
import com.example.superherov4.dto.HeroesInCityDTO;
import com.example.superherov4.dto.HeroNameCreationDTO;
import com.example.superherov4.dto.RealNameSuperpowersDTO;
import com.example.superherov4.model.Superhero;
import com.example.superherov4.repositories.SuperheroRepository_DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository_DB repository;

    public SuperheroService(SuperheroRepository_DB superhero){
        this.repository = superhero;
    }

    public List<Superhero> getSuperheroes() {
        return repository.getSuperheroes();
    }

    public Superhero getSuperhero(String superheroName) {
        return repository.getSuperhero(superheroName);
    }

    public List<HeroNameCreationDTO> getNameCreation(String superheroName) {
        return repository.searchSuperheroes(superheroName);
    }
    public List<CountSuperpowersDTO> getCountSuperheroCount(String superheroName) {
        return repository.getSuperpowerCount(superheroName);
    }

    public List<RealNameSuperpowersDTO> getRealNameSuperpowers(String superheroName) {
        return repository.getRealNameSuperpowers(superheroName);
    }

    public List<HeroesInCityDTO> getHeroCity(String cityName) {
        return repository.getHeroCity(cityName);
    }

}
