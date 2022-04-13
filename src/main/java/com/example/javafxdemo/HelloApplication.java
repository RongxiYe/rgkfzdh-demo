package com.example.javafxdemo;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
//        Handler h = new Handler();
//        CurrentData cd = new CurrentData();
        AnchorPane root = Handler.getRoot(Page.MAIN);
        Controller main = Handler.getController(Page.MAIN);
        main.init();
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}