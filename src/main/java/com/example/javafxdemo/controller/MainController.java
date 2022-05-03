package com.example.javafxdemo.controller;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.login.HelloController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class MainController implements Controller{
    @FXML
    public AnchorPane mainanchor;
    public Button exit;
    public Button help;
    public Button back;



    public void init(){
        AnchorPane root = Handler.getRoot(Page.BOOKNUMLOGIN);
        Controller hello = Handler.getController(Page.BOOKNUMLOGIN);
        hello.init();
        mainanchor.getChildren().add(root);
        int num = mainanchor.getChildren().size();
        mainanchor.getChildren().get(num-2).setVisible(false);

    }

    public void loadRoot(Page page) {
        AnchorPane root = Handler.getRoot(page);
        Handler.getController(page).init();
        CurrentData.currentPage = page;
        int num = mainanchor.getChildren().size();
        if (page==Page.FIRSTPAGE){
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
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.HELPINFO);
    }

    @FXML
    public void back(){
        Page lastPage = CurrentData.currentPage.back();

        if (lastPage==null){
            System.out.println("Error!");
            System.exit(1);
        }else{
            loadRoot(lastPage);
        }

    }

}
