package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SumResult;


@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/{valueA}/{valueB}")
    public Integer testPathVariable(
            @PathVariable Integer valueA,
            @PathVariable Integer valueB) {
        return valueA + valueB;
    }



    @GetMapping("/{valueA}")
    public SumResult testPathVariableWithCases(
        @PathVariable Integer valueA,
        Integer valueB) {
        
        if(valueB == null)
            valueB = 0;
                

        return new SumResult(valueA+valueB, valueA+valueB % 2 == 0);
    }



    @GetMapping("/add")     
    public Integer testParams(Integer valueA, Integer valueB) {
        return valueA + valueB;
    }
    
}
