package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import com.example.javafxdemo.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ButtonBar.ButtonData;

import java.util.ArrayList;
import java.util.Optional;

public class MealController implements Controller {

    /*@FXML
    private Button nextpage;
    @FXML
    private Button choosestaple;
    @FXML
    private Button choosehalal;
    @FXML
    private Button chooseDAD;
    @FXML
    private Label mealInfo;

    public AnchorPane mealAnchor;*/

    private String mealType;

    public void init(){
        System.out.println("Initialing meal info");
        mealType = null;
    }

    @FXML public void onClickNextPageButton(){
        if(mealType == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            ButtonType buttonReturn = new ButtonType("RETURN", ButtonData.CANCEL_CLOSE);
            alert.setTitle("Warning");
            alert.setHeaderText("Meal Not Selected");
            alert.setContentText("Required to choose your meal before going to next page!");
            alert.getButtonTypes().setAll(buttonReturn);
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType buttonConfirm = new ButtonType("CONFIRM", ButtonData.NEXT_FORWARD);
            ButtonType buttonModify = new ButtonType("MODIFY", ButtonData.CANCEL_CLOSE);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Please Check Out Your Meal Information");
            alert.getButtonTypes().setAll(buttonConfirm, buttonModify);
            if(mealType == "Set Meal") {
                alert.setContentText("MEAL: " + mealType + "\n" + "EXTRA PAYMENT: 5$");
            }
            else {
                alert.setContentText("MEAL: " + mealType + "\n" + "NO EXTRA PAYMENT");
            }
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonConfirm) {
                MainController main = (MainController) Handler.getController(Page.MAIN);
                main.loadRoot(Page.SMCONFIRM);
            }
            else {
                MainController main = (MainController)Handler.getController(Page.MAIN);
                main.loadRoot(Page.MEALSELECT);
            }
        }
    }

    @FXML public void onClickChooseStaple(){
        //令。。。等于normal,修改userdata
        mealType = "normal";
        UserData userData = CurrentData.userData;
        userData.setMeal(mealType);
    }


    @FXML public void onClickChooseHalal(){
        //令。。。等于halal
        mealType = "halal";
        UserData userData = CurrentData.userData;
        userData.setMeal(mealType);
    }

    @FXML public void onClickChooseSET(){
        //如果选择了套餐，则需要额外加钱，先将值赋给meal，
        //跳转到smconfirm界面后，通过判断值是否为extra，如果是extra，则在smconfirm界面计算金额
        mealType = "Set Meal";
        UserData userData = CurrentData.userData;
        userData.setMeal(mealType);
    }


}
