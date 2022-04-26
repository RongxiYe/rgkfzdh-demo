package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Optional;

public class SeatController implements Controller {
        @FXML
        private String tempSeatNum;
        private Rectangle lastRect;
        private boolean ifClicked = false;

        public void init() {

        }

        @FXML
        protected void onClickNextPageButton(){
                if(tempSeatNum == null){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText("Seat Not Selected");
                        alert.setContentText("Required to choose your seat before going to next page!");
                        alert.showAndWait();
                }else{
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Please Confirm Your Seat");
                        if(tempSeatNum.charAt(1) == '1'){
                                alert.setContentText("SEAT: " + tempSeatNum + "\n" + "EXTRA PAYMENT: 50$");
                        }else{
                                alert.setContentText("SEAT: " + tempSeatNum + "\n" + "EXTRA PAYMENT: 0");
                        }
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK){
                                CurrentData.userData.setSeatNum(tempSeatNum);
                                MainController main = (MainController) Handler.getController(Page.MAIN);
                                main.loadRoot(Page.MEALSELECT);
                        }
                }
        }

        public void onClickSeat(MouseEvent event){
                Rectangle rect = (Rectangle) event.getSource();
                rect.setFill(Color.AQUA);
                if(ifClicked == false){
                        tempSeatNum = rect.getId();
                        ifClicked = true;
                }else{
                        if(lastRect.getId().charAt(1) == '1'){
                                lastRect.setFill(Color.ORANGE);
                        }else{
                                lastRect.setFill(Color.web("#b8bbde"));
                        }
                        tempSeatNum = rect.getId();
                }
                lastRect = rect;
        }

}
