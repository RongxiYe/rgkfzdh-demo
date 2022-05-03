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

public class SmConfirmController implements Controller {

    @FXML
    private Button confirmSelect;
    @FXML
    private Label seatInfo;
    @FXML
    private Label mealInfo;
    @FXML
    private Label seatselect;
    @FXML
    private Label mealselect;
    public AnchorPane smConfirmAnchor;


    public void init(){
        UserData userData = CurrentData.userData;
        //show page information depending on whether user has extra payments.
        seatInfo.setText(userData.getSeatNum());
        mealInfo.setText(userData.getMeal());

        String stn = userData.getSeatNum();
        String ml = userData.getMeal();
        if(ml == "Set Meal"){
            String meal1 = "Set Meal";
            String meal2 = "Need extra payment 5$";
            String string1 = meal1 + "\n" + meal2;
            mealselect.setText(string1);
        }else{
            String meal = "No extra payment";
            String string1 = meal;
            mealselect.setText(string1);
        }
        if(stn.charAt(1) == '1'){
            String seat1 = "Special Seat";
            String seat2 = "Need extra payment 50$";
            String string2 = seat1 + "\n" + seat2;
            seatselect.setText(string2);
        }else{
            String seat = "No extra payment";
            String string2 = seat;
            seatselect.setText(string2);
        }



        if(true){
            //have extra payments
            smConfirmAnchor.getChildren().get(5).setVisible(false);
            smConfirmAnchor.getChildren().get(4).setVisible(true);

        }else{
            smConfirmAnchor.getChildren().get(5).setVisible(true);
            smConfirmAnchor.getChildren().get(4).setVisible(false);

        }
    }

    //@FXML public void onClickInputButton(){
        //use loaders to enter the next page.
    //    MainController main = (MainController) Handler.getController(Page.MAIN);
    //    main.loadRoot(Page.EXTRAPAY);
    //}


    @FXML public void onClickConfirmButton(){
        UserData userData = CurrentData.userData;
        String stn = userData.getSeatNum();
        String ml = userData.getMeal();
        if(ml == "Set Meal" && stn.charAt(1) == '1'){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Please pay for your extra payment");
            alert.setContentText("SEAT: " + stn + "\n" + "MEAL: " + ml + "\n" + "EXTRA PAYMENT: 55$");
            Optional<ButtonType> result = alert.showAndWait();
            //use loaders to enter the next page.
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.CREDITINFO);
        }else if(ml == "Set Meal" && stn.charAt(1) != '1'){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Please pay for your extra payment");
            alert.setContentText("SEAT: " + stn + "\n" + "MEAL: " + ml + "\n" + "EXTRA PAYMENT: 5$");
            Optional<ButtonType> result = alert.showAndWait();
            //use loaders to enter the next page.
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.CREDITINFO);
        }else if(ml != "Set Meal" && stn.charAt(1) == '1'){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Please pay for your extra payment");
            alert.setContentText("SEAT: " + stn + "\n" + "MEAL: " + ml  + "\n" + "EXTRA PAYMENT: 50$");
            Optional<ButtonType> result = alert.showAndWait();
            //use loaders to enter the next page.
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.CREDITINFO);
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Please pay for your extra payment");
            alert.setContentText("There is no extra payment.");
            Optional<ButtonType> result = alert.showAndWait();
            //use loaders to enter the next page.
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.CHECKINVIEW);
        }
    }

    @FXML public void onClickChangeSeat(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.SEATSELECT);
    }

    @FXML public void onClickChangeMeal(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.MEALSELECT);
    }


}
