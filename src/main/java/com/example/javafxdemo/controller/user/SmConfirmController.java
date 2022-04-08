package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SmConfirmController {

    @FXML
    private Button inputInfo;
    @FXML
    private Label seatInfo;
    @FXML
    private Label mealInfo;
    public AnchorPane smConfirmAnchor;

    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
        //show page information depending on whether user has extra payments.
        if(true){

        }else{

        }
    }

    @FXML public void onClickInputButton(){
        //use loaders to enter the next page.
    }


}
