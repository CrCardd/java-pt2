package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.desktopapp.model.User;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class AdmSceneController implements Initializable{
     
    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = AdmSceneController.class
                        .getResource("main-adm-users-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    private VBox box;
    @FXML
    private Button btnAddUser;
    @FXML
    private Button btnAddProduct;
    @FXML
    private TableView<User> tbUser;
    @FXML
    private TableColumn<User, Long> colId;
    @FXML
    private TableColumn<User, String> colName;


    @FXML
    protected void addUser(ActionEvent e) throws IOException{
        var stage = new Stage();
        stage.setScene(AdmAddUserSceneController.CreateScene());
        stage.show();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(
                new PropertyValueFactory<>("name"));


        Context ctx = new Context();
        var query = ctx.createQuery(User.class, "FROM User u");
        List<User> get = query.getResultList();

        tbUser.setItems(FXCollections.observableArrayList(get));
    }

    @FXML
    public void botafogo() throws IOException{

        Context ctx = new Context();
        Long current_id = tbUser.getSelectionModel().getSelectedItems().getFirst().getId();
        var query = ctx.createQuery(User.class, 
            "FROM User WHERE Id = :id");
        query.setParameter("id", current_id);
        
        User current_user = query.getSingleResult();


        Scene new_scene = AdmEditSceneController.CreateScene(current_user);
        Stage stage = new Stage();
        stage.setScene(new_scene);
        stage.show();
    }


}