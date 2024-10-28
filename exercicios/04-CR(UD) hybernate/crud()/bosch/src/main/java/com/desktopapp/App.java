package com.desktopapp;

import com.desktopapp.model.Product;
import com.desktopapp.model.User;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        User user = new User();
        User user_ = new User();
        User user__ = new User();

        user.setName("a");
        user.setPassword("a");
        user.setAdm(true);
        
        user_.setName("z");
        user_.setPassword("z");
        user_.setAdm(false);

        user__.setName("x");
        user__.setPassword("x");
        user__.setAdm(false);


        Product p = new Product();
        p.setName("banana");
        Product p1 = new Product();
        p1.setName("potato");


        Context ctx = new Context();
        ctx.begin();
        ctx.persist(user);
        ctx.persist(user_);
        ctx.persist(user__);
        ctx.persist(p);
        ctx.persist(p1);
        ctx.commit();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = LoginSceneController.CreateScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }  
}
