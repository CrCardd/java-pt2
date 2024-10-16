package com.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.util.Timer;
import java.util.TimerTask;

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
    
    Timer timer = new Timer();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        var g = simulador.getGraphicsContext2D();
        Massa massa =  new Massa(100,200,200,20, Color.BLUE);
        Massa massa1 = new Massa(100,280,200,20, Color.RED);
        Massa massa2 = new Massa(100,200,280,20, Color.GREEN);
        Massa massa3 = new Massa(100,280,280,20, Color.YELLOW);

        Mola mola = new   Mola(10000, 1, massa, massa1);
        Mola mola1 = new  Mola(10000, 1, massa1, massa2);
        Mola mola2 = new  Mola(10000, 1, massa2, massa3);
        Mola mola3 = new  Mola(10000, 1, massa3, massa);
        Mola mola4 = new  Mola(10000, 1, massa, massa2);
        Mola mola5 = new  Mola(10000, 1, massa1, massa3);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                g.clearRect(0, 0, simulador.getWidth(), simulador.getHeight());
                
                massa.exercer(simulador);
                massa1.exercer(simulador);
                massa2.exercer(simulador);
                massa3.exercer(simulador);

                mola.exercer(simulador);
                mola1.exercer(simulador);
                mola2.exercer(simulador);
                mola3.exercer(simulador);
                mola4.exercer(simulador);
                mola5.exercer(simulador);
                
                box.requestLayout();
            }
        }, 50, 50);
    }




    
    

}
