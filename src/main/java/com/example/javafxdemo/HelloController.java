package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField bn;
    public AnchorPane helloanchor;


    @FXML
    protected void onClickCheckInButton() throws IOException {
        String booknum = bn.getText();
        if(true){
            System.out.println(booknum);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Check in successfully!");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("checkin-view.fxml"));
            helloanchor.getScene().setRoot(fxmlLoader.load());
        }else{

        }

    }
}