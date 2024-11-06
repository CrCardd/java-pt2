package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Plaindrome;

@RestController
@RequestMapping("/reverse")
public class C1_challenge {
    
    @GetMapping("/{word}")
    public Plaindrome plaindrome(
        @PathVariable String word
    ){
        Boolean result = false;
        String reverse = new StringBuilder(word).reverse().toString();
        if(reverse.equals(word))
            result = true;
        
        return new Plaindrome(word, reverse, result);
    }
}
