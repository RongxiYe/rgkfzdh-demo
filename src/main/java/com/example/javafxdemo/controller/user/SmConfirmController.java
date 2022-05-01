package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SmConfirmController implements Controller {

    @FXML
    private Button inputInfo;
    @FXML
    private Button confirmSelect;
    @FXML
    private Label seatInfo;
    @FXML
    private Label mealInfo;
    public AnchorPane smConfirmAnchor;


    public void init(){
        UserData userData = CurrentData.userData;
        //show page information depending on whether user has extra payments.
        seatInfo.setText(userData.getSeatNum());
        mealInfo.setText(userData.getMeal());
        //show extra money how?

        //if (meal = "extra"){
        //进行金钱的计算，seat&meal (mealextra： + $5)
        // }
        //..........

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
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.EXTRAPAY);
    }

    @FXML public void onClickConfirmButton(){
        //use loaders to enter the next page.
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.CHECKINVIEW);
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
