package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Collatz;

@RestController
@RequestMapping("/collatz")
public class C3_challenge {
    
    @GetMapping
    public ResponseEntity<Collatz> collatz(Integer step, Integer current) {
        if(step < 0 || current < 0)
            return new ResponseEntity<>(new Collatz(0), HttpStatus.BAD_REQUEST);
            
        while(step-- > 0)
            if(current%2 == 0)
                current/=2;
            else
                current = (current * 3) + 1;
        
        return new ResponseEntity<>(new Collatz(current), HttpStatus.OK);
    }
}
