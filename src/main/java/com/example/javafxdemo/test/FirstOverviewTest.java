package com.example.javafxdemo.test;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.controller.login.HelloController;
import com.example.javafxdemo.controller.user.FirstViewController;
import com.example.javafxdemo.controller.user.SmConfirmController;
import com.example.javafxdemo.data.UserData;
import com.example.javafxdemo.utils.ClassPath;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FirstOverviewTest extends Application{

public static void main(String[]args){
        launch(args);
        }

@Override
public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        FXMLLoader smLoader = new FXMLLoader(HelloApplication.class.getResource("sm-confirm.fxml"));
        FXMLLoader fvLoader = new FXMLLoader(HelloApplication.class.getResource("first-view.fxml"));
        AnchorPane root = fxmlLoader.load();
        MainController main = fxmlLoader.getController();
        AnchorPane smroot = smLoader.load();
        AnchorPane fvroot =fvLoader.load();

        UserData userData = new UserData();
        FXMLLoader[] loaders = new FXMLLoader[20];

//        SmConfirmController smc = smLoader.getController();
//        smc.init(userData,loaders);
//        root.getChildren().add(smroot);
//        int num = root.getChildren().size();
//        root.getChildren().get(num-2).setVisible(false);

        FirstViewController fvc = fvLoader.getController();
        fvc.init(userData,loaders);
        root.getChildren().add(fvroot);
        int num = root.getChildren().size();
        root.getChildren().get(num-2).setVisible(false);

        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

//        System.out.println(ClassPath.classPath);
//        File file = new File(ClassPath.classPath+"Data.json");
//        System.out.println(file.exists());

        }
}
