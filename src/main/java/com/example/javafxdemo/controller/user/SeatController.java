package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class SeatController{
        @FXML
        private UserData userData;
        private FXMLLoader[] loaders;
        private String tempSeatNum;

        public void init(UserData data, FXMLLoader[] loaders) {
                this.userData = data;
                this.loaders = loaders;
        }

        @FXML
        protected void onClickNextPageButton() throws IOException {
                userData.setSeatNum(tempSeatNum);
                PrintPageController ppc = loaders[2].getController();
                ppc.init(userData, loaders);
                MainController main = loaders[0].getController();
                main.loadRoot(loaders[2]);
        }

        public void onClickSeat(MouseEvent event) throws IOException {
                Rectangle rect = (Rectangle) event.getSource();
                rect.setFill(Color.AQUA);
                tempSeatNum = rect.getId();

        }

}
