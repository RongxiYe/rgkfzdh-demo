package com.example.javafxdemo.controller.login;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.controller.user.PrintPageController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField bn;
    public AnchorPane helloanchor;
    private FXMLLoader[] loaders;
    private UserData userData;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
    }

    @FXML
    protected void onClickCheckInButton() throws IOException {
        String booknum = bn.getText().trim();
        Alert alert;
        if (booknum.isEmpty()||booknum==null){
            alert = new Alert(Alert.AlertType.ERROR,"Empty input! Please input something!");
            alert.showAndWait();
            System.out.println("empty");

        }else{

            //search in file for user information
            //if there exist a user, do something
            //do not forget to change the condition of if clause
            if(true){
                System.out.println(booknum);
                alert = new Alert(Alert.AlertType.INFORMATION,"Check in successfully!");
                alert.showAndWait();


                //userdata赋值
                PrintPageController ppc = loaders[2].getController();
                ppc.init(userData,loaders);
                MainController main = loaders[0].getController();
                main.loadRoot(loaders[2]);

            }else{
                alert = new Alert(Alert.AlertType.ERROR,"Wrong booking number! Please input again");
                alert.showAndWait();
            }
        }


    }

}