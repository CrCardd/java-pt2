package com.desktopapp;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Massa{

    private double peso;
    private double posicaoX;
    private double posicaoY;
    private double velocidadeX;
    private double velocidadeY;
    private double raio;
    private double diametro;
    private double aceleracaoY;
    private double aceleracaoX;
    private Color color;

    static double gravidade = 980;



    public Massa(double peso, double posicaoX, double posicaoY, double raio, Color color) {
        this.peso = peso;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.velocidadeX = 0;
        this.velocidadeY = 0;
        this.raio = raio;
        this.diametro = raio*2;
        this.aceleracaoY = 98;
        this.aceleracaoX = 0;
        this.color = color;
    }
    
    
    
    
    public double getPeso() {
        return peso;
    }
    public double getPosicaoX() {
        return posicaoX;
    }
    public void setPosicaoX(double posicaoX) {
        this.posicaoX = posicaoX;
    }
    public double getPosicaoY() {
        return posicaoY;
    }
    public void setPosicaoY(double posicaoY) {
        this.posicaoY = posicaoY;
    }
    public double getVelocidadeX() {
        return velocidadeX;
    }
    public void setVelocidadeX(double velocidadeX) {
        this.velocidadeX = velocidadeX;
    }
    public double getVelocidadeY() {
        return velocidadeY;
    }
    public void setVelocidadeY(double velocidadeY) {
        this.velocidadeY = velocidadeY;
    }
    public double getRaio() {
        return raio;
    }
    public double getDiametro() {
        return this.diametro;
    }
    // public double getAceleracaoY() {
    //     return aceleracaoY;
    // }
    // public void setAceleracaoY(double aceleracao) {
    //     this.aceleracaoY = aceleracao;
    // }
    // public double getAceleracaoX() {
    //     return aceleracaoX;
    // }
    // public void setAceleracaoX(double aceleracao) {
    //     this.aceleracaoX = aceleracao;
    // }
    
    
    public void exercer(Canvas simulador){
        
        double height = simulador.getHeight(), width = simulador.getWidth();


        this.velocidadeY += gravidade * 0.05; 

        this.posicaoX += this.velocidadeX * 0.05; 
        this.posicaoY += this.velocidadeY * 0.05; 
        
        if (this.posicaoY > height-this.diametro){
            this.velocidadeY *= -0.9;
            this.posicaoY = height - this.diametro;
            this.velocidadeX *= 0.9;
        }
        else if(this.posicaoY <= 0){
            this.velocidadeY *= -1;
            this.posicaoY = 0;
        }

        if(this.posicaoX >= width - this.diametro){
            this.velocidadeX *= -1;
            this.posicaoX = width - this.diametro;
        }
        else if(this.posicaoX <= 0){
            this.velocidadeX *= -1;
            this.posicaoX = 0;
        }

        

        
        simulador.getGraphicsContext2D().setFill(color);
        simulador.getGraphicsContext2D().fillOval(this.posicaoX, this.posicaoY, this.diametro, this.diametro);
    }


}
