package com.example.javafxdemo.controller;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.login.HelloController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {
    @FXML
    public AnchorPane mainanchor;
    private FXMLLoader[] loaders;
    private UserData userData;


    public void init(FXMLLoader mainLoader) throws IOException{
        loaders = new FXMLLoader[20];
        FXMLLoader helloLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader printLoader = new FXMLLoader(HelloApplication.class.getResource("checkin-view.fxml"));
        loaders[0] = mainLoader;
        loaders[1] = helloLoader;
        loaders[2] = printLoader;
        userData = new UserData();
//        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        AnchorPane root = helloLoader.load();
        printLoader.load();
        HelloController hello = helloLoader.getController();
        hello.init(userData,loaders);
        mainanchor.getChildren().add(root);
    }

    public void loadRoot(FXMLLoader loader) {
        AnchorPane root = loader.getRoot();
        int num = mainanchor.getChildren().size();
        mainanchor.getChildren().remove(num-1);
        mainanchor.getChildren().add(root);
    }



}
