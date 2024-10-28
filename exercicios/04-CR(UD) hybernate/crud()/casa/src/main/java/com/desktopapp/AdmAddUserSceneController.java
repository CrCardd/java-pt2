package com.desktopapp;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdmAddUserSceneController {
    
    static Scene CreateScene() throws IOException{
        URL sceneUrl = AdmSceneController.class
                        .getResource("main-adm-adduser-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;


    }
}
