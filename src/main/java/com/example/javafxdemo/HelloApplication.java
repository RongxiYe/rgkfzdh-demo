package com.example.javafxdemo;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.utils.Page;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Start the whole process
 *
 * @author RongxiYe
 * @version 1.0
 */
public class HelloApplication extends Application {

    /**
     * Loading the first page
     */
    @Override
    public void start(Stage stage) {
        Handler.stage = stage;
        AnchorPane root = Handler.getRoot(Page.FIRSTPAGE);
        Controller first = Handler.getController(Page.FIRSTPAGE);
        first.init();
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Smart Check In!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Start-up procedure
     *
     * @param args String
     */
    public static void main(String[] args) {
        launch();
    }
}