package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import javafx.fxml.FXML;

/**
 * Class LastPageController is used to control last-page.fxml
 * it helps to finish the program
 */
public class LastPageController implements Controller {

    /**
     * override parent class method to initialize the page
     */
    @Override
    public void init(){}

    /**
     * exit the whole program
     */
    @FXML
    public void onClickButton(){
        System.exit(0);
    }
}
