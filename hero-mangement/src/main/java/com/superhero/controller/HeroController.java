package com.superhero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.exception.RecordNotFoundException;
import com.superhero.model.SuperHero;
import com.superhero.service.HeroService;


@RestController
@RequestMapping("/heroes")
public class HeroController
{
    @Autowired
    HeroService heroservice; 
    
    @GetMapping
    public ResponseEntity<List<SuperHero>> getAllHeroes() {
        List<SuperHero> list = heroservice.getAllsuperheros();		
        return new ResponseEntity<List<SuperHero>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
   
    @GetMapping("/{id}")
    public ResponseEntity<SuperHero> getHeroById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        SuperHero entity = heroservice.getsuperheroById(id);
 
        return new ResponseEntity<SuperHero>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<SuperHero> createOrUpdateEmployee(SuperHero hero)
                                                    throws RecordNotFoundException {
        SuperHero updated = heroservice.createOrUpdatesuperhero(hero);
        return new ResponseEntity<SuperHero>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        heroservice.deletesuperheroById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}