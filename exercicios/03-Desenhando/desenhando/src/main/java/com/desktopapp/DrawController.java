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
import javafx.scene.layout.VBox;


public class DrawController implements Initializable{
  
    public static Scene CreateScene() throws Exception
    {
        
        URL sceneUrl = DrawController.class
        .getResource("main-scene.fxml");
        
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);

        DrawController controller = loader.getController();

        return scene;
    }
    

    private double rotation = 0;


    Timer timer = new Timer();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                rotation += Math.PI / 20;
                draw();
                box.requestLayout();
            }
        }, 50, 50);
    }

    @FXML
    private Canvas cvMain;
    @FXML
    private VBox box;


    private void draw(){
        
        var g = cvMain.getGraphicsContext2D();

        g.clearRect(0, 0, cvMain.getWidth(), cvMain.getHeight());

        double[] xs = new double[10];
        double[] ys = new double[10];
        double theta = 0f;

        for(int i=0; i<10; i++){
            double rho = i % 2 == 0 ? 200 : 80;

            xs[i] = rho * Math.cos(theta);    
            ys[i] = rho * Math.sin(theta);    

            theta += 2 * Math.PI / 10;
        }

        for(int i=0; i<10; i++){
            var x = xs[i];
            var y = ys[i];

            xs[i] = x * Math.cos(rotation) + y * Math.sin(rotation);
            ys[i] = x * Math.sin(rotation) - y * Math.cos(rotation);
        }

        for(int i=0; i<10; i++){
            xs[i] += cvMain.getWidth() / 2;
            ys[i] += cvMain.getHeight() / 2;
        }


        g.fillPolygon(xs, ys, 10);
    }

    

    
}
