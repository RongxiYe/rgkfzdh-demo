package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SmConfirmController {

    @FXML
    private Button inputInfo;
    @FXML
    private Button confirmSelect;
    @FXML
    private Label seatInfo;
    @FXML
    private Label mealInfo;
    public AnchorPane smConfirmAnchor;

    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
        //show page information depending on whether user has extra payments.
        seatInfo.setText(userData.getSeatNum());
        mealInfo.setText(userData.getMeal());
        //show extra money how?
        if(true){
            //have extra payments
            smConfirmAnchor.getChildren().get(5).setVisible(false);
            smConfirmAnchor.getChildren().get(4).setVisible(true);

        }else{
            smConfirmAnchor.getChildren().get(5).setVisible(true);
            smConfirmAnchor.getChildren().get(4).setVisible(false);

        }
    }

    @FXML public void onClickInputButton(){
        //use loaders to enter the next page.
        CreditInfoController cic = loaders[2].getController();
        cic.init(userData, loaders);
        MainController main = loaders[0].getController();
        main.loadRoot(loaders[2]);
    }

    @FXML public void onClickConfirmButton(){
        //use loaders to enter the next page.
        PrintPageController ppc = loaders[2].getController();
        ppc.init(userData, loaders);
        MainController main = loaders[0].getController();
        main.loadRoot(loaders[2]);
    }

    @FXML public void onClickChangeSeat(){
        MealController mc = loaders[2].getController();
        mc.init(userData, loaders);
        MainController main = loaders[0].getController();
        main.loadRoot(loaders[2]);
    }

    @FXML public void onClickChangeMeal(){

    }


}
