package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MealController {

    @FXML
    private Button mealconfirm;
    @FXML
    private Button choosestaple;
    @FXML
    private Button choosehalal;
    @FXML
    private Button chooseDAD;

    public AnchorPane mealAnchor;

    public String mealselection;

    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;

    }

    @FXML public void onClickConfirmButton(){
        //跳转到smconfrim界面
        SmConfirmController smcc = loaders[2].getController();
        smcc.init(userData, loaders);
        MainController main = loaders[0].getController();
        main.loadRoot(loaders[2]);
    }

    @FXML public void onClickChooseStaple(){
        //令。。。等于normal,修改json文件
        mealselection = "normal";

    }

    @FXML public void onClickChooseHalal(){
        //令。。。等于halal
        mealselection = "halal";
    }

    @FXML public void onClickChooseDAD(){
        //令。。。+ DAD & extra payment
        mealselection = "DAD (extra payment)";
    }


}
