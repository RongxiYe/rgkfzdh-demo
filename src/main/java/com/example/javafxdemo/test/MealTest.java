package com.example.javafxdemo.test;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.controller.user.MealController;
import com.example.javafxdemo.utils.UserData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MealTest extends Application{

public static void main(String[]args){
        launch(args);
        }

@Override
public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
//        FXMLLoader mealLoader = new FXMLLoader(HelloApplication.class.getResource("meal-select.fxml"));
//        AnchorPane root = fxmlLoader.load();
//        MainController main = fxmlLoader.getController();
//        AnchorPane mealroot = mealLoader.load();
//
//        UserData userData = new UserData();
//        FXMLLoader[] loaders = new FXMLLoader[20];
//
//        MealController mc = mealLoader.getController();
//        mc.init(userData,loaders);
//        root.getChildren().add(mealroot);
//        int num = root.getChildren().size();
//        root.getChildren().get(num-2).setVisible(false);
//
//        Scene scene = new Scene(root, 900, 600);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
        }
}
