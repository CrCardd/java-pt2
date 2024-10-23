package com.desktopapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.desktopapp.model.Product;
import com.desktopapp.model.UserProduct;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UserSceneController implements Initializable{

    
    public void setIdUser(Long id){
        this.id_user = id;
    }

    public static Scene CreateScene(Long id) throws Exception
    {
        URL sceneUrl = AdmSceneController.class
            .getResource("main-user-scene.fxml");
            
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        UserSceneController controller = loader.getController();

        controller.loadShoppingList();
        controller.setIdUser(id);

        return scene;
    }
    private Long id_user;
    @FXML
    private VBox box;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private Button btnLogout;
    @FXML
    private TableView<Product> tbTable;
    @FXML
    private TableColumn<Product, Double> priceCol;
    @FXML
    private TableColumn<Product, String> productCol;
    @FXML
    private TableColumn<Product, Long> quantityCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Context ctx = new Context();
        var query = ctx.createQuery(Product.class,"FROM Product");

        ArrayList<ShowProduct> showProducts = new ArrayList<>();

        List<Product> products = query.getResultList();

        Iterator<Product> iterator = products.iterator();
        Integer n = 0;
        while(iterator.hasNext())
            showProducts.add(new ShowProduct(iterator.next(), ancPane, 40, (40+((n++)*55)), addUserProduct));



        // productCol.setCellValueFactory(
        //         new PropertyValueFactory<>("name"));
        // priceCol.setCellValueFactory(
        //         new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
                
    }

    private final Operations addUserProduct = (id_product, quantity) -> {
        if(quantity <= 0)
            return;

        UserProduct shop = new UserProduct();
        shop.setId_user(this.id_user);
        shop.setId_product(id_product);
        shop.setQuantity(quantity);

        Context ctx = new Context();
        ctx.begin();
        ctx.persist(shop);
        ctx.commit();
        
        loadShoppingList();
    };

    private void loadShoppingList(){
        Context ctx = new Context();
        var query = ctx.createQuery(Product.class,"FROM UserProduct WHERE id_user = :id_user");
        query.setParameter("id_user", id_user);

        List<Product> userProducts = query.getResultList();
        tbTable.setItems(FXCollections.observableArrayList(userProducts));

        

        System.out.println("\n\n\n\nENTREI AQUI MEU CHAPA\n\n\n");

        System.out.println(userProducts);
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

}
