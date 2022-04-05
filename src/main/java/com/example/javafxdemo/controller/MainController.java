package com.example.javafxdemo.controller;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.login.HelloController;
import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class MainController {
    @FXML
    public AnchorPane mainanchor;
    public Button exit;
    public Button help;
    public Button back;
    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;


    public void init(FXMLLoader mainLoader) throws IOException{
        loaders = new FXMLLoader[20];
        FXMLLoader helloLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader printLoader = new FXMLLoader(HelloApplication.class.getResource("checkin-view.fxml"));
        loaders[0] = mainLoader;
        loaders[1] = helloLoader;
        loaders[2] = printLoader;
        //还有很多其他的页面都在这里初始化
        userData = new UserData();
//        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        AnchorPane root = helloLoader.load();
        printLoader.load();
        HelloController hello = helloLoader.getController();
        hello.init(userData,loaders);
        mainanchor.getChildren().add(root);
        int num = mainanchor.getChildren().size();
        mainanchor.getChildren().get(num-2).setVisible(false);
    }

    public void loadRoot(FXMLLoader loader) {
        AnchorPane root = loader.getRoot();
        currentLoader = loader;
        int num = mainanchor.getChildren().size();
        if (loader==loaders[1]){
            mainanchor.getChildren().get(num-2).setVisible(false);
        }else{
            mainanchor.getChildren().get(num-2).setVisible(true);
        }
        mainanchor.getChildren().remove(num-1);
        mainanchor.getChildren().add(root);
    }


    @FXML
    public void exit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to exit?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Exit");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==ButtonType.YES)
            System.exit(0);

    }


    @FXML
    public void help(){

    }

    @FXML
    public void back(){
        int index = findIndex();
        if (index==-1){
            System.out.println("Error!");
            System.exit(1);
        }else{
            loadRoot(loaders[index-1]);
        }

    }

    public int findIndex(){
        for (int i = 0; i < 20; i++) {
            if (loaders[i]==currentLoader){
                return i;
            }
        }
        return -1;
    }
}
