package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import java.io.IOException;
import java.text.SimpleDateFormat;
import com.example.javafxdemo.utils.ClassPath;
import com.example.javafxdemo.utils.Tool;
import com.google.gson.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FirstViewController {
    @FXML
    public AnchorPane firstViewAnchor;
    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;
    public Label infoContent;
    public Button fvConfirm;
    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
        //airline information 打印
        String bn = userData.getBookingNum();
        String sn = userData.getSurname();
        String fn = userData.getFirstname();
        String an = userData.getFlightNum();
        String dep = userData.getDepAddr();

        String date = userData.getFlyingDate();
        String po = userData.getDelayStatus();
        String cg = userData.getLuggage();


        String des = userData.getDesAddr();

        String string1 = sn+"\n"+"\n\n"+fn+"\n"+"\n"+an+"\n"+"\n\n"+dep+"\n"+"\n"+des+"\n"+"\n"+date+"\n"+"\n\n"+cg+"\n"+"\n\n"+po;
        infoContent.setText(string1);

    }
    @FXML public void ConfirmButton() throws IOException{
        //use loaders to enter the next page.
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure the information is correct?");
        alert.showAndWait();
    }

}
