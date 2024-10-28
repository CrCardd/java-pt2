package com.desktopapp;


import com.desktopapp.model.Product;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ShowProduct extends Region {

    private Label lbName = new Label();
    private Label lbQuantity = new Label();
    private Button btnAdd = new Button();
    private Button btnRemove = new Button();
    private Button btnSubmit = new Button();
    private Pane pane = new Pane();

    public ShowProduct(Product product, AnchorPane ancPane, Integer x, Integer y, Operations submitAction){

        pane.getChildren().addAll(lbName, btnAdd, btnRemove, lbQuantity, btnSubmit);
        
        lbName.setText(product.getName());
        lbQuantity.setText("0");
        
        btnAdd.setOnAction(e -> {
            Integer crr = Integer.parseInt(lbQuantity.getText());
            if(crr < 10)
                lbQuantity.setText(String.valueOf(crr + 1));
        });
        btnAdd.setText("➕");
        
        btnRemove.setOnAction(e -> {
            Integer crr = Integer.valueOf(lbQuantity.getText());
            if(crr > 0)
                lbQuantity.setText(String.valueOf(crr - 1));
        });
        btnRemove.setText("➖");

        btnSubmit.setOnAction(e -> {
            submitAction.UserProductOperation(product.getId(), Long.parseLong(lbQuantity.getText()));
        });
        btnSubmit.setText("Submit");
        
        
        lbName.setLayoutX(0);
        lbName.setLayoutY(0);
        
        btnRemove.setLayoutX(0);
        btnRemove.setLayoutY(19);
        
        lbQuantity.setLayoutX(36);
        lbQuantity.setLayoutY(22);
        
        btnAdd.setLayoutX(50);
        btnAdd.setLayoutY(19);

        btnSubmit.setLayoutX(88);
        btnSubmit.setLayoutY(19);
        
        pane.setLayoutX(x);
        pane.setLayoutY(y);
        
        ancPane.getChildren().add(pane);
    }

    public Integer getQuantity(){
        return Integer.parseInt(this.lbQuantity.getText());
    }

    public String getName(){
        return this.lbName.getText();
    }
    
}
