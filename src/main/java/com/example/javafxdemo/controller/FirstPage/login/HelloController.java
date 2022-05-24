package com.example.javafxdemo.controller.FirstPage.login;

import com.example.javafxdemo.controller.*;
import com.example.javafxdemo.utils.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class HelloController implements Controller {
    @FXML
    private TextField bn;
    public AnchorPane helloanchor;
    @FXML
    private Hyperlink upload;
    @FXML
    private Hyperlink inputID;

    @Override
    public void init() {}

    @FXML
    protected void onClickCheckInButton() {
        String booknum = bn.getText().trim();
        Alert alert;
        if (booknum.isEmpty() || booknum == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Empty input! Please input something!");
            alert.showAndWait();
            System.out.println("empty");
        } else {
            UserData ud = Utils.login(booknum);
            Utils.loginCheck(ud,"Wrong booking number! Please input again");
        }
    }

    @FXML
    protected void uploadId(){
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDCARDLOGIN);
    }
    @FXML
    protected void inputID(){
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDINFOLOGIN);
    }
}