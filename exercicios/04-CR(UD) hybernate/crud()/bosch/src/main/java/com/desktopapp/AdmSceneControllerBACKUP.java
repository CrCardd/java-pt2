package com.desktopapp;

import java.net.URL;
import java.util.List;

import com.desktopapp.model.Product;
import com.desktopapp.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class AdmSceneControllerBACKUP {
     
    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = AdmSceneController.class
                        .getResource("main-adm-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }
    @FXML
    Button btnSubmit;
    @FXML
    Button btnLogout;
    @FXML
    TextField lbLogin;
    @FXML
    TextField lbPassword;
    @FXML
    CheckBox cIfAdm;
    @FXML
    Label message;


    @FXML
    Button btnProductSubmit;
    @FXML
    TextField lbProductName;
    @FXML
    TextField lbProductPrice;
    @FXML
    Label productMessage;

    @FXML
    protected void register(ActionEvent e){
        Context ctx = new Context();
        var query = ctx.createQuery(User.class,
            "FROM User u WHERE u.name = :name");
        query.setParameter("name", lbLogin.getText());
        List<User> users = query.getResultList();
        
        if(!users.isEmpty()){
            Alert alert = new Alert(
                AlertType.ERROR,
                "Já existe um usuário com este login!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }

        message.setText("User added succesfully!");
        User new_user = new User();
        new_user.setAdm(cIfAdm.isSelected());
        new_user.setName(lbLogin.getText());
        new_user.setPassword(lbPassword.getText());

        ctx.begin();
        ctx.persist(new_user);
        ctx.commit();
    }

    @FXML
    protected void registerProduct(ActionEvent e){
        Context ctx = new Context();
        var query = ctx.createQuery(Product.class,
            "FROM Product p WHERE p.name = :name");
        query.setParameter("name", lbProductName.getText());
        List<Product> products = query.getResultList();
        
        if(!products.isEmpty()){
            Alert alert = new Alert(
                AlertType.ERROR,
                "Este produto já está cadastrado!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
        }

        productMessage.setText("Product added succesfully!");
        Product new_product = new Product();
        new_product.setName(lbProductName.getText());
        new_product.setPrice(Double.parseDouble(lbProductPrice.getText()));

        ctx.begin();
        ctx.persist(new_product);
        ctx.commit();
    }

    

    @FXML
    protected void logout(ActionEvent e) throws Exception{
        var crrStage = (Stage)btnLogout
            .getScene().getWindow();
        crrStage.close();
 
        var stage = new Stage();
        var scene = LoginSceneController.CreateScene();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void initCreate(){
        message.setText("");
    }
    @FXML
    protected void initCreateProduct(){
        productMessage.setText("");
    }




}