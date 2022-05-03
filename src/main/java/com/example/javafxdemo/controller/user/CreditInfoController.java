package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreditInfoController implements Controller {

    @FXML
    private Button confirmInput;
    @FXML
    private TextField cardID;
    @FXML
    private PasswordField password;

    public AnchorPane CreditInfoAnchor;

    public void init(){}

    @FXML
    public void onClickConfirmInput(){
        String creditnum = cardID.getText().trim();
        Alert alert;
        if (creditnum.isEmpty() || creditnum == null || password.isDisabled() || password == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Empty input! Please input something!");
            alert.showAndWait();
            System.out.println("empty");
        } else {
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.CHECKINVIEW);
        }
    }
}
