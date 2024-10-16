package com.desktopapp;

import javafx.scene.canvas.Canvas;

public class Mola {
    
    private double resistencia;
    private double comprimento;
    private Massa massa1;
    private Massa massa2;


    public Mola(double resistencia, double comprimento, Massa massa1, Massa massa2) {
        this.resistencia = resistencia;
        this.comprimento = comprimento;
        this.massa1 = massa1;
        this.massa2 = massa2;
    }


    public void exercer(Canvas simulador){
        double massa1X = massa1.getPosicaoX() + massa1.getRaio();
        double massa1Y = massa1.getPosicaoY() + massa1.getRaio();
        
        double massa2X = massa2.getPosicaoX() + massa2.getRaio();
        double massa2Y = massa2.getPosicaoY() + massa2.getRaio();
        


        double distancia = Math.sqrt(Math.pow(massa1X - massa2X,2) + Math.pow(massa1Y - massa2Y, 2));
        double distanciaX = massa1X - massa2X;
        double distanciaY = massa1Y - massa2Y;

        double deformacao = this.comprimento - distancia;


        double forca = resistencia * deformacao;

        // Direção da força
        double forcaX = forca * ((distanciaX) / distancia);
        double forcaY = forca * ((distanciaY) / distancia);

        // Atualizando a aceleração das massas
        massa1.setVelocidadeX(forcaX / massa1.getPeso() + massa1.getVelocidadeX());
        massa1.setVelocidadeY((forcaY/massa1.getPeso()) + massa1.getVelocidadeY());

        massa2.setVelocidadeX(-forcaX / massa2.getPeso() + massa2.getVelocidadeX());
        massa2.setVelocidadeY((forcaY/massa2.getPeso()) + massa2.getVelocidadeY());


        simulador.getGraphicsContext2D().strokeLine(
            massa1X, massa1Y,
            massa2X, massa2Y
        );
    }

    
}
