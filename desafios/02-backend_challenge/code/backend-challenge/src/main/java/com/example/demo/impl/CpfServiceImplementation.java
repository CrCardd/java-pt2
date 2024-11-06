package com.example.demo.impl;

import com.example.demo.services.CpfService;

public class CpfServiceImplementation implements CpfService {
    @Override
    public Boolean validate(String cpf) {

        Integer i=0;
        Integer verify_one = 0;
        Integer verify_two = 0;

        for(i=0; i<cpf.length()-2; i++)
            verify_one += Integer.valueOf(String.valueOf(cpf.charAt(i))) * (i+1);
        verify_one%=11;
        verify_one%=10;
        
        for(i=0; i<cpf.length()-2; i++)
            verify_two += Integer.valueOf(String.valueOf(cpf.charAt(i))) * i;
        verify_two+=verify_one*i;
        verify_two%=11;
        verify_two%=10;
        
        return  Integer.valueOf(String.valueOf(cpf.charAt(cpf.length()-2))).equals(verify_one) &&
                Integer.valueOf(String.valueOf(cpf.charAt(cpf.length()-1))).equals(verify_two);
    }
    
}
