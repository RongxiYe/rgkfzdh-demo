package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MealController implements Controller {

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



    public void init(){


    }

    @FXML public void onClickConfirmButton(){
        //跳转到smconfrim界面
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.SMCONFIRM);
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
