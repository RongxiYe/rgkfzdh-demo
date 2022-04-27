package com.example.javafxdemo.controller.login;

import com.example.javafxdemo.controller.*;
import com.example.javafxdemo.utils.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;

public class ScanFileController implements Controller {
    @FXML
    private Button confirmUpload;
    @FXML
    private Hyperlink booknum;
    @FXML
    private Hyperlink inputID;
    private File file;

    @Override
    public void init(){}

    @FXML
    public void onClickConfirmUpload(){
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader(file));
            String id = object.get("id").getAsString();
            String name = object.get("name").getAsString();
            UserData ud = Utils.login(name,id);
            Utils.loginCheck(ud,"Illegal id card! Please re-upload!");
            file=null;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickUploadId(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON", "*.json")
        );
        file = fileChooser.showOpenDialog(Handler.stage);
    }

    @FXML
    public void inputBooknum(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.BOOKNUMLOGIN);
    }

    @FXML
    protected void inputID(){
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDINFOLOGIN);
    }

}
