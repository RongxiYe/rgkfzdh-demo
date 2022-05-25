package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
/**
 * Class CreditInfoController is used to control creait-info.fxml and
 * it helps to check the credit
 *
 * @author dxzSabrina, RongxiYe
 * @version 1.0
 */
public class CreditInfoController implements Controller {

    /**
     * text for the ID of the card
     */
    @FXML
    private TextField cardID;
    /**
     * text for password
     */
    @FXML
    private PasswordField password;

    /**
     * initialize the page
     */
    public void init(){
        cardID.setTextFormatter(new TextFormatter<String>(new IntegerFilter()));
    }

    /**
     * check whether the input is empty
     */
    @FXML
    public void onClickConfirmInput(){
        Alert alert;
        if (cardID.getText().trim().isEmpty() || cardID.getText() == null || password.getText().trim().isEmpty() || password.getText()  == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Empty input! Please input something!");
            ButtonType buttonModify = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.setTitle("Error!");
            alert.setHeaderText("Error!");
            alert.getButtonTypes().setAll(buttonModify);
            alert.showAndWait();
            System.out.println("empty");
        } else {
            if(creditCheck(cardID.getText().trim(),password.getText().trim())){
                MainController main = (MainController) Handler.getController(Page.MAIN);
                main.loadRoot(Page.CHECKINVIEW);
            }else{
                alert = new Alert(Alert.AlertType.ERROR, "Error! Please input correct info!");
                ButtonType buttonModify = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.setTitle("Error!");
                alert.setHeaderText("Error!");
                alert.getButtonTypes().setAll(buttonModify);
                alert.showAndWait();
            }

        }
    }

    /**
     * check whether the credit is reasonable
     * @param no number of credit card
     * @param pass password of the card
     * @return a boolean represents if it has passed the check
     */
    private boolean creditCheck(String no, String pass){
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new InputStreamReader(HelloApplication.class.getResourceAsStream("/com/example/javafxdemo/Credit.json")));
            JsonArray array = object.get("CreditCard").getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                JsonObject subObject = array.get(i).getAsJsonObject();
                String name = CurrentData.userData.getFirstname()+" "+CurrentData.userData.getSurname();
                String nameInFile = subObject.get("name").getAsString();
                String noInFile = subObject.get("cardNo").getAsString();
                String passInFile = subObject.get("cardPass").getAsString();
                if (nameInFile.equals(name)&&no.equals(noInFile)&&pass.equals(passInFile)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
