package com.desktopapp;

import java.net.URL;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainController {
    
    
    private Integer id;
    private Circle portalOne = new Circle(50, Color.BLUE);
    private Circle portalTwo = new Circle(50, Color.RED);


    @FXML
    private Pane player ;
    
    public void setID(Integer id) {
        this.id = id;
    }    
    
    public static Scene CreateScene(Integer id) throws Exception
    {
        
        URL sceneUrl = MainController.class
        .getResource("main-scene.fxml");
        
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);

        MainController controller = loader.getController();
        controller.setID(id);
        
        controller.ScreenAll.requestFocus();

        return scene;
    }
    
    // @FXML
    // protected void initialize(URL location, ResourceBundle Resources){}
    
    @FXML
    protected void onButtonClick(MouseEvent e) throws Exception
    {
        Stage naovejo = (Stage)loginButton
        .getScene()
        .getWindow();
        
        naovejo.close();
        
        Stage newStage = new Stage();
        Scene newScene = MainController.CreateScene(this.id + 1);
        newStage.setScene(newScene);
        newStage.show();
    }

    @FXML
    protected Button loginButton;
    
    @FXML
    protected TextField emailInput;
    
    @FXML
    protected CheckBox visibilityButton;
    
    @FXML
    protected PasswordField passwordInput;
    
    @FXML
    protected Pane ScreenAll; 
    
    // @FXML
    // protected Pane ScreenAll; 


    private boolean   setPortal  = true;

    @FXML
    protected void onMouseClick(MouseEvent click){
        Double x = click.getScreenX();
        Double y = click.getScreenY();
        
        System.out.println(click.getButton().toString());

        switch (click.getButton().toString()) {
            case "PRIMARY":
                portalOne.setLayoutX(x);
                portalOne.setLayoutY(y);
                break;
        
            case "SECONDARY":
                portalTwo.setLayoutX(x);
                portalTwo.setLayoutY(y);
                break;
        }

        if(setPortal){
            ScreenAll.getChildren().addAll(portalOne,portalTwo);
            setPortal = false;
        }
    }


    @FXML
    protected void onKeyPressed(KeyEvent key){

        String pressed = key.getCode().toString();

        Double pX = player.getLayoutX();
        Double pY = player.getLayoutY();

        System.out.println(pressed);

        switch (pressed) {
            case "W":
                player.setLayoutY(pY-10);
                break;
            case "A":
                player.setLayoutX(pX-10);
                break;
            case "S":
                player.setLayoutY(pY+10);
                
                break;
            case "D":
                player.setLayoutX(pX+10);
                break;
            case "NUMPAD0":
                System.out.println("-----PASSEI POR AQUI------");
                if(player.getBoundsInParent().intersects(portalTwo.getBoundsInParent())){
                    player.setLayoutX(portalOne.getLayoutX() - 45);
                    player.setLayoutY(portalOne.getLayoutY() - 45);
                    System.out.println("INDO PRO BLUE");
                }
                else if(player.getBoundsInParent().intersects(portalOne.getBoundsInParent())){
                    player.setLayoutX(portalTwo.getLayoutX() - 45);
                    player.setLayoutY(portalTwo.getLayoutY() - 45);
                    System.out.println("INDO PRO RED");
                }
                break;
        
            default:
                break;
        }


    }


    @FXML
    protected Circle brincar;


    @FXML
    protected void brincando(MouseEvent mouse){
        
        Double dX = brincar.getLayoutX() - mouse.getSceneX();
        Double dY = brincar.getLayoutY() - mouse.getSceneY();
        
        // System.out.println("--------------------------");
        // System.out.println("dx");
        // System.out.println(dX);
        // System.out.println("dy");
        // System.out.println(dY);
        // System.out.println("raio");
        // System.out.println(brincar.getRadius());
        // System.out.println("x");
        // System.out.println(brincar.getLayoutX());
        // System.out.println("y");
        // System.out.println(brincar.getLayoutY());
        // System.out.println("testX");
        // System.out.println(brincar.getLayoutX() + (dX / brincar.getRadius()));
        // System.out.println("testY");
        // System.out.println(brincar.getLayoutY() + (dY / brincar.getRadius()));

        brincar.setLayoutX(brincar.getLayoutX() + (dX / brincar.getRadius() * -1));
        brincar.setLayoutY(brincar.getLayoutY() + (dY / brincar.getRadius() * -1));

    }

    AnimationTimer tent = new AnimationTimer() {
        
        @Override
        public void handle(long timestamp){
            System.err.println("TESTANDO");
            tent.start();
        }
    };




    // AnimationTimer collisionTime = new AnimationTimer() {
        
    //     @Override
    //     public void handle(long timestamp){
    //         checkteleportOne(player, portalOne);
    //         checkteleportTwo(player, portalTwo);
    //     }

    //     // @Override
    //     // public void initialize(URL url, ResourceBundle resourceBundle){
    //     //     Scene scene = (Scene)player.getScene();

    //         // MovementController movementController = new MovementController(player, scene);

    //         // collisionTime.start();
    //     // }

    //     public void checkteleportOne(Pane player, Circle portal){
            
    //     }
    // };

    //AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII


}
