package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Optional;

public class PrintPageController {
    @FXML
    public Label airLineInfo;
    public Label extraPay;
    public AnchorPane checkinanchor;
    private UserData userData;
    private FXMLLoader[] loaders;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;

        //airLineInfo和extraPay换行显示data
        airLineInfo.setText(String.valueOf(userData));
        extraPay.setText(String.valueOf(userData));
    }

    @FXML
    protected void onClickPrintMaterialButton() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure to print all your materials?");
        alert.showAndWait();

        //打印出信息文件
        //生成发给后台系统的文件
    }


}
