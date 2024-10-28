package com.desktopapp;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.ArcType;

public class Massa{

    private double peso;
    private double posicaoX;
    private double posicaoY;
    private double velocidadeX;
    private double velocidadeY;
    private double raio;
    private double diametro;
    private double aceleracao;



    public Massa(double peso, double posicaoX, double posicaoY, double raio) {
        this.peso = peso;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.raio = raio;
        this.diametro = raio*2;
        this.aceleracao = 0;
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
    public double getPosicao(){
        return this.posicaoY + this.raio;
    }
    public void setAceleracao(double aceleracao){
        this.aceleracao = aceleracao;
    }

    public void exercer(Canvas simulador){
        var g = simulador.getGraphicsContext2D();
        g.clearRect(0, 0, simulador.getWidth(), simulador.getHeight());

        // System.err.println("PASSEI AQUI");
        // System.err.println(posicaoY);
        // System.err.println(aceleracao);
        
        g.fillArc(this.posicaoX, this.posicaoY, this.diametro, this.diametro, 0, 360, ArcType.ROUND);
        
        this.aceleracao += 0.66;
        this.posicaoY += aceleracao;
    }



}
