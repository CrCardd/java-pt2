package com.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.ArcType;

public class MainController implements Initializable {
      
    public static Scene CreateScene() throws Exception
    {
        
        URL sceneUrl = MainController.class
        .getResource("main-scene.fxml");
        
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);

        MainController controller = loader.getController();

        return scene;
    }

    @FXML
    private Canvas simulador;
    @FXML
    private VBox box;
    
    Massa massa = new Massa(10, 100, 100, 20);



    Timer timer = new Timer();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                
                if(massa.getPosicao() < simulador.getHeight()){
                    massa.exercer(simulador);
                } else {
                    massa.setAceleracao(0);
                }
                
                  
               
                box.requestLayout();
            }
        }, 25, 25);
    }



    @FXML
    public void segurar(MouseEvent e){

        // double dx = e.getX() - massa.getPosicaoX();
        // double dy = e.getY() - massa.getPosicaoY();

        // double angle = 180 * Math.atan2(dy, -dx) / Math.PI + 180;

        
        // if(angle > 0 && angle < 360){
        //     System.out.println("TAPORRA");
        //     System.out.println(angle);
        //     System.out.println(dx);
        //     System.out.println(dy);

        // }

        
    }


}
