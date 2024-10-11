package com.desktopapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.ArcType;


public class DrawController implements Initializable{

    private ArrayList<Float> values = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();
    private Integer selected = -1;

    public void add(float value, Color color){
        this.values.add(value);
        this.colors.add(color);
    }
    
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        add(60f, Color.BLUE);
        add(40f, Color.RED);
        add(30f, Color.GREEN);
        draw();
    }

    @FXML
    private Canvas cvMain;

    @FXML
    private VBox box;


    //Mouse moved
    @FXML
    protected void botafogo(MouseEvent e){
        var g = cvMain.getGraphicsContext2D();

        double width = cvMain.getWidth();
        double height = cvMain.getHeight();
        double sum = this.values.stream()
            .reduce(0f,(a, x) -> a + x);

        
        double cx = width/2;
        double cy = height/2;

        double dx = e.getX() - cx;
        double dy = e.getY() - cy;

        double angle = 180 * Math.atan2(dy, -dx) / Math.PI + 180;

        double currentArc = 0;

        for(int i=0; i<this.values.size(); i++){
            Float value = this.values.get(i);
            double arc = 360 * value / sum;

            double initAngle  = currentArc;
            double finalAngle = currentArc + arc; 

            if(angle > initAngle && angle < finalAngle)
                selected = i;

            currentArc += arc;
        }

        draw();
        box.requestLayout();
        
    }

    //Mouse pressed
    @FXML
    protected void vasco(){

    }

    //mouse released
    @FXML
    protected void flamengo(){

    }

    private void draw(){
        var g = cvMain.getGraphicsContext2D();

        double width = cvMain.getWidth();
        double height = cvMain.getHeight();
        double sum = this.values.stream()
            .reduce(0f,(a, x) -> a + x);

        
        double currentArc = 0;
        for(int i=0; i<this.values.size(); i++){
            Float value = this.values.get(i);
            Color color = this.colors.get(i);

            double arc = 360 * value / sum;

            if(selected == i){
                color = new Color( 
                    0.6 * color.getRed()  + 0.4,
                    0.6 * color.getGreen() + 0.4,
                    0.6 * color.getBlue() + 0.4,
                    1f
                );
            }
            
            g.setFill(color);
            g.fillArc(0,0,width,height,currentArc,arc,ArcType.ROUND);

            currentArc += arc;
        }


    }
    







}
