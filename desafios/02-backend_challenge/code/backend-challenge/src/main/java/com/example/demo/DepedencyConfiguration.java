package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.dto.Token;
import com.example.demo.services.CpfService;
import com.example.demo.services.EncoderService;
import com.example.demo.services.JwtService;
import com.example.demo.services.UserAuthService;
import com.example.demo.services.UserService;
import com.example.demo.services.impl.CpfServiceImplementation;
import com.example.demo.services.impl.EncoderImplementation;
import com.example.demo.services.impl.JwtImplementation;
import com.example.demo.services.impl.UserAuthImplementation;
import com.example.demo.services.impl.UserImplementation;

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

    @Bean
    @Scope("singleton")                     //CRIA UM UNICO OBJETO PARA TODO O PROGRAMA 
    public EncoderService encoderService(){
        return new EncoderImplementation();
    }

    @Bean
    @Scope("singleton")                     //CRIA UM UNICO OBJETO PARA TODO O PROGRAMA 
    public UserAuthService userAuthService(){
        return new UserAuthImplementation();
    }

    @Bean
    @Scope("singleton")                     //CRIA UM UNICO OBJETO PARA TODO O PROGRAMA 
    public JwtService<Token> jwtService(){
        return new JwtImplementation();
    }
}
