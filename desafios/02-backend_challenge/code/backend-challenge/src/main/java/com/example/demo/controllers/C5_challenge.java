package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.repositories.CitiesRepository;

@RestController
@RequestMapping("/cities")
public class C5_challenge {
    @Autowired
    CitiesRepository repo;

    @GetMapping
    public ResponseEntity<List<City>> getAll(){
        List<City> all = repo.findAll();

        if(all.isEmpty())
            return new ResponseEntity<>(all, HttpStatus.NO_CONTENT);
        else 
            return new ResponseEntity<>(all, HttpStatus.OK);
    }
    
    @GetMapping("/{search}")
    public ResponseEntity<List<City>> getCity(@PathVariable String search){
        List<City> cities = repo.findByName(search);
        
        if(cities.isEmpty())
            return new ResponseEntity<>(cities, HttpStatus.NOT_FOUND);
        else 
            return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
