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

    @FXML
    private Button nextpage;
    @FXML
    private Button choosestaple;
    @FXML
    private Button choosehalal;
    @FXML
    private Button chooseset;
    @FXML
    private Label mealInfo;

    public AnchorPane mealAnchor;

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
        choosestaple.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff ");
        choosehalal.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        chooseset.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        CurrentData.userData.setMeal("normal");
        mealType = "normal";
    }


    @FXML public void onClickChooseHalal(){
        choosestaple.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        choosehalal.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff");
        chooseset.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        CurrentData.userData.setMeal("halal");
        mealType = "halal";
    }

    @FXML public void onClickChooseSET(){
        choosestaple.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        choosehalal.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        chooseset.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff");
        CurrentData.userData.setMeal("Set Meal");
        mealType = "Set Meal";
    }


}
