package com.example.javafxdemo.controller.login;

import com.example.javafxdemo.controller.*;
import com.example.javafxdemo.utils.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;

public class InputIdController implements Controller {
    @FXML
    private Button confirmInput;
    @FXML
    private Hyperlink booknum;
    @FXML
    private Hyperlink upload;
    @FXML
    private TextField surname;
    @FXML
    private TextField idnumber;

    public InputIdController() {
    }

    @Override
    public void init(){}

    @FXML
    public void onClickConfirmInput(){
        try {
            String name = surname.getText().trim();
            String id = idnumber.getText().trim();
            UserData ud = Utils.login(name,id);
            Utils.loginCheck(ud,"Illegal id card! Please re-upload!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void inputBooknum(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.BOOKNUMLOGIN);
    }
    @FXML
    public void uploadId(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDCARDLOGIN);
    }


}