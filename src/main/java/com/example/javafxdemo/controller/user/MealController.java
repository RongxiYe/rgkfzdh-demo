package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

public class MealController implements Controller {

    @FXML
    private Button mealconfirm;
    @FXML
    private Button choosestaple;
    @FXML
    private Button choosehalal;
    @FXML
    private Button chooseDAD;
    @FXML
    private Label mealInfo;

    public AnchorPane mealAnchor;

    public String mealselection;

    public void init(){


    }

    @FXML public void onClickConfirmButton(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Please Confirm Your Meal");
        if(mealselection == "Set Meal"){
            alert.setContentText("Meal: " + mealselection + "\n" + "EXTRA PAYMENT: 5$");
        }else{
            alert.setContentText("Meal: " + mealselection + "\n" + "NO EXTRA PAYMENT");
        }
        Optional<ButtonType> result = alert.showAndWait();
        //跳转到smconfrim界面
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.SMCONFIRM);
    }

    @FXML public void onClickChooseStaple(){
        //令。。。等于normal,修改userdata
        mealselection = "normal";
        UserData userData = CurrentData.userData;
        userData.setMeal(mealselection);
    }


    @FXML public void onClickChooseHalal(){
        //令。。。等于halal
        mealselection = "halal";
        UserData userData = CurrentData.userData;
        userData.setMeal(mealselection);
    }

    @FXML public void onClickChooseSET(){
        //如果选择了套餐，则需要额外加钱，先将值赋给meal，
        //跳转到smconfirm界面后，通过判断值是否为extra，如果是extra，则在smconfirm界面计算金额
        mealselection = "Set Meal";
        UserData userData = CurrentData.userData;
        userData.setMeal(mealselection);
    }


}
