package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class SeatController implements Controller {
        @FXML
        private String tempSeatNum;

        public void init() {

        }

        @FXML
        protected void onClickNextPageButton(){
                CurrentData.userData.setSeatNum(tempSeatNum);
                MainController main = (MainController) Handler.getController(Page.MAIN);
                main.loadRoot(Page.CHECKINVIEW);
        }

        public void onClickSeat(MouseEvent event){
                Rectangle rect = (Rectangle) event.getSource();
                rect.setFill(Color.AQUA);
                tempSeatNum = rect.getId();

        }

}
