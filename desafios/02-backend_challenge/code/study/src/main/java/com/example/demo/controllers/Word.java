package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.WordDto;

@RestController
@RequestMapping("/reverse")
public class Word {
    
    @GetMapping("/{word}")
    public ResponseEntity<WordDto> isPalindrome(@PathVariable String word){
        String result = new StringBuilder(word).reverse().toString();

        return new ResponseEntity<>(new WordDto(result, result.equals(word)), HttpStatus.OK);
    }
}
