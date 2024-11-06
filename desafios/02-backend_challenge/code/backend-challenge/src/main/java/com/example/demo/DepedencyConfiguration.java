package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.impl.CpfServiceImplementation;
import com.example.demo.impl.UserImplementation;
import com.example.demo.services.CpfService;
import com.example.demo.services.UserService;

@Configuration
public class DepedencyConfiguration {
    
    @Bean
    @Scope("singleton")                     //CRIA UM UNICO OBJETO PARA TODO O PROGRAMA 
    // @Scope("prototype")                  //TODA VEZ QUE PRECISAR DE UM OBJETO, ELE CRIA UM NOVO
    // @Scope("request")                    //PARA UMA ÚNICA REQUISIÇÃO ELE USA O MESMO OBJETO
    // @Scope("session")                    //O OBJETO VAI SAER USADO PARA TUDO DO USUARIO SELECIONAODI
    public CpfService cpfService(){
        return new CpfServiceImplementation();
    }
    
    @Bean
    @Scope("singleton")                     //CRIA UM UNICO OBJETO PARA TODO O PROGRAMA 
    public UserService UserService(){
        return new UserImplementation();
    }
}
