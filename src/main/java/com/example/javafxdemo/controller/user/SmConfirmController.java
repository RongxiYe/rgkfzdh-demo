package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SmConfirmController {
    @FXML
    public AnchorPane smConfirmAnchor;
    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
    }

}
