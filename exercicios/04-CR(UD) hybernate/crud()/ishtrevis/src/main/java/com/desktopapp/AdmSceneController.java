package com.desktopapp;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
 
public class AdmSceneController {
     
    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = AdmSceneController.class
                        .getResource("main-adm-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }


    @FXML
    Button btnAddUser;
    @FXML
    Button btnAddProduct;
    


    @FXML
    protected void addUser(ActionEvent e){
        
    }
 
    @FXML
    protected void addProduct(ActionEvent e){
        
    }

    

    @FXML
    protected void logout(ActionEvent e) throws Exception{
        var crrStage = (Stage)btnAddUser
            .getScene().getWindow();
        crrStage.close();
 
        var stage = new Stage();
        var scene = LoginSceneController.CreateScene();
        stage.setScene(scene);
        stage.show();
    }




}