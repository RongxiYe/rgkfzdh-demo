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
/**
 * Class MealController is used to control meal-select.fxml and
 * it helps to select the meal
 *
 * @author ritacrthh, Mzybupt, xxx_
 * @version 1.0
 */
public class MealController implements Controller {

    /**
     * button to select staple food
     */
    @FXML
    private Button choosestaple;
    /**
     * button to select halal food
     */
    @FXML
    private Button choosehalal;
    /**
     * button to selcet set food
     */
    @FXML
    private Button chooseset;

    /**
     * root of the page
     */
    public AnchorPane mealAnchor;

    /**
     * meal type of current choice
     */
    private String mealType;

    /**
     * initialize the page and obtain current selection
     */
    public void init(){
        System.out.println("Initialing meal info");
        mealType = CurrentData.userData.getMeal();
    }

    /**
     * button that can go to the next page when you click it
     * alert the information about food selection
     */
    @FXML public void onClickNextPageButton(){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType buttonConfirm = new ButtonType("Yes", ButtonData.NEXT_FORWARD);
            ButtonType buttonModify = new ButtonType("No", ButtonData.CANCEL_CLOSE);
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


    /**
     * button to go to choose staple food
     */
    @FXML public void onClickChooseStaple(){
        choosestaple.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff ");
        choosehalal.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        chooseset.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        CurrentData.userData.setMeal("Staple");
        mealType = "Staple";
    }


    /**
     * button to go to choose halal food
     */
    @FXML public void onClickChooseHalal(){
        choosestaple.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        choosehalal.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff");
        chooseset.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        CurrentData.userData.setMeal("Halal");
        mealType = "Halal";
    }


    /**
     * button to go to choose set meal
     */
    @FXML public void onClickChooseSET(){
        choosestaple.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        choosehalal.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: #fff4e6;-fx-text-fill: #f49e31; ");
        chooseset.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff");
        CurrentData.userData.setMeal("Set Meal");
        mealType = "Set Meal";
    }


}
