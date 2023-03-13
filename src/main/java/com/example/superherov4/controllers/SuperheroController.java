package com.example.superherov4.controllers;


import com.example.superherov4.dto.CountSuperpowersDTO;
import com.example.superherov4.dto.HeroesInCityDTO;
import com.example.superherov4.dto.HeroNameCreationDTO;
import com.example.superherov4.dto.RealNameSuperpowersDTO;
import com.example.superherov4.model.Superhero;
import com.example.superherov4.services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "KEA") //KEA
public class SuperheroController {

    private final SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping(path = "superhero") //KEA/superheroes
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroList = superheroService.getSuperheroes();

        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);
    }

    @GetMapping(path = "superhero/{superheroName}") //KEA/superhero/{superheroName}
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String superheroName) {
        Superhero theSuperhero = superheroService.getSuperhero(superheroName);

        return new ResponseEntity<Superhero>(theSuperhero, HttpStatus.OK);

    }

    @GetMapping(path = "superheroSearch/{superheroName}") //KEA/superhero/{superheroName}
    public ResponseEntity <List<HeroNameCreationDTO>> searchSuperheroes(@PathVariable String superheroName) {
        List<HeroNameCreationDTO> superheroResults = superheroService.getNameCreation(superheroName);

        return new ResponseEntity<List<HeroNameCreationDTO>>(superheroResults, HttpStatus.OK);

    }

    @GetMapping(path = "countSuperpower/{superheroName}") //KEA/superhero/{superheroName}
    public ResponseEntity <List<CountSuperpowersDTO>> countSuperpowers(@PathVariable String superheroName) {
        List<CountSuperpowersDTO> superheroResults = superheroService.getCountSuperheroCount(superheroName);

        return new ResponseEntity<List<CountSuperpowersDTO>>(superheroResults, HttpStatus.OK);

    }

    @GetMapping(path = "realNameSuperpowers/{superheroName}") //KEA/superhero/{superheroName}
    public ResponseEntity <List<RealNameSuperpowersDTO>> realNameSuperpowers(@PathVariable String superheroName) {
        List<RealNameSuperpowersDTO> superheroResults = superheroService.getRealNameSuperpowers(superheroName);

        return new ResponseEntity<List<RealNameSuperpowersDTO>>(superheroResults, HttpStatus.OK);

    }
    @GetMapping(path = "heroNameCity/{cityName}") //KEA/superhero/{superheroName}
    public ResponseEntity <List<HeroesInCityDTO>> heroNameCity(@PathVariable String cityName) {
        List<HeroesInCityDTO> superheroResults = superheroService.getHeroCity(cityName);

        return new ResponseEntity<List<HeroesInCityDTO>>(superheroResults, HttpStatus.OK);

    }

}
