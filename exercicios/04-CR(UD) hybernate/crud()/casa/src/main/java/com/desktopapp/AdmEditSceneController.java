package com.desktopapp;

import java.io.IOException;
import java.net.URL;

import com.desktopapp.implementations.userRepository;
import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdmEditSceneController{
    
    private User user;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        System.out.println("\n\n\n\n\nTO AQUI MLK");
        this.user = user;
    }

    static Scene CreateScene(User user_) throws IOException{
        URL sceneUrl = AdmSceneController.class
                        .getResource("main-adm-edit-scene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        AdmEditSceneController controller = loader.getController();

        controller.setUser(user_);

        System.out.println(user_.getName());

        controller.initialize(user_);

        return scene;
    }

    @FXML
    TextField inputName;
    @FXML
    PasswordField inputPassword;
    @FXML
    Button btnSubmit;
    @FXML
    CheckBox checkAdmin;
    @FXML
    Label message;
    @FXML
    Label setID;


    public void initialize(User user) {
        setID.setText(String.valueOf(user.getId()));
        checkAdmin.setDisable(user.getAdm());
        inputName.setText(user.getName());
        inputPassword.setText(user.getPassword());
    }

    @FXML
    protected void UpdateUser(){
        user.setAdm(checkAdmin.isSelected());
        user.setName(inputName.getText());
        user.setPassword(inputPassword.getText());

        userRepository userRepo = new userRepository();
        userRepo.update(user);
    }
}
