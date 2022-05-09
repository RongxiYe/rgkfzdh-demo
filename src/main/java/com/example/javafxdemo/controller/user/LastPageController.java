package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import javafx.fxml.FXML;


public class LastPageController implements Controller {

    @Override
    public void init(){}

    @FXML
    public void onClickButton(){
        System.exit(0);
    }
}
