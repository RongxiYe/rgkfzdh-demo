package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import com.example.javafxdemo.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Class MainController is used to control seat-select.fxml and
 * performs all interaction of choosing seat for users.
 *
 * @author Honey-Mydear
 * @version 1.0
 */
public class SeatController implements Controller {

        /**
         * seat number
         */
        @FXML
        private String tempSeatNum;
        /**
         * last selected rectangle
         */
        private Rectangle lastRect;
        /**
         * if the user click on rectangle
         */
        private boolean ifClicked = false;

        /**
         * init() is used to initialize seat-select.fxml and load it.
         * It scans all file that has been printed and see which seat has been taken.
         * It displays all occupied seat in color red.
         */
        public void init(){
                System.out.println("Initialing seat info");
                /*ArrayList<String> seatOccupied = new ArrayList<String>();
                seatOccupied.add("F3");
                seatOccupied.add("D7");*/
                ArrayList<String> seatOccupied = Utils.initialSeatPage();
                for(int i = 0; i < seatOccupied.size(); i++){
                        Parent root = Handler.getRoot(Page.SEATSELECT);
                        String seatId = seatOccupied.get(i);
                        Rectangle rect = (Rectangle) root.lookup("#" + seatId);
                        rect.setDisable(true);
                        rect.setFill(Color.RED);
                }
        }

        /**
         * onClickNextPageButton() is used to display a confirmation box after user clicked next page button.
         * It generates mechanism to improve robustness of the code.
         * It sends seat information to back end user object.
         */
        @FXML
        protected void onClickNextPageButton(){
                if(tempSeatNum == null){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        ButtonType buttonModify = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Seat Not Selected");
                        alert.setContentText("Required to choose your seat before going to next page!");
                        alert.getButtonTypes().setAll(buttonModify);
                        alert.showAndWait();
                }else{
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        ButtonType buttonConfirm = new ButtonType("Yes", ButtonBar.ButtonData.NEXT_FORWARD);
                        ButtonType buttonModify = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                        alert.getButtonTypes().setAll(buttonConfirm, buttonModify);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Please Check Out Your Seat Information");
                        if(tempSeatNum.charAt(1) == '1'){
                                alert.setContentText("SEAT: " + tempSeatNum + "\n" + "EXTRA PAYMENT: 50$");
                        }else{
                                alert.setContentText("SEAT: " + tempSeatNum + "\n" + "NO EXTRA PAYMENT");
                        }
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == buttonConfirm){
                                CurrentData.userData.setSeatNum(tempSeatNum);
                                MainController main = (MainController) Handler.getController(Page.MAIN);
                                main.loadRoot(Page.MEALSELECT);
                        }
                }
        }

        /**
         * onClickSeat() is used to ensure that only one seat can be selected at a time.
         * @param event event of the mouse
         */
        public void onClickSeat(MouseEvent event){
                Rectangle rect = (Rectangle) event.getSource();
                if(!rect.isDisabled()) {
                        rect.setFill(Color.AQUA);
                        if (ifClicked == false) {
                                tempSeatNum = rect.getId();
                                ifClicked = true;
                        } else {
                                if (lastRect.getId().charAt(1) == '1') {
                                        lastRect.setFill(Color.ORANGE);
                                } else {
                                        lastRect.setFill(Color.web("#b8bbde"));
                                }
                                if(lastRect == rect){
                                        tempSeatNum = null;
                                }else{
                                        tempSeatNum = rect.getId();
                                }
                        }

                        lastRect = rect;
                }
        }

}
