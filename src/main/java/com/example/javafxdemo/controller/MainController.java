package com.example.javafxdemo.controller;

import javafx.scene.text.Text;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class MainController implements Controller{
    @FXML
    public AnchorPane mainanchor;
    public Button exit;
    public Button help;
    public Button back;
    public Text day;



    public void init(){
        AnchorPane root = Handler.getRoot(Page.BOOKNUMLOGIN);
        Controller hello = Handler.getController(Page.BOOKNUMLOGIN);
        hello.init();
        mainanchor.getChildren().add(root);
        int num = mainanchor.getChildren().size();
        mainanchor.getChildren().get(num-2).setVisible(false);

        //date
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MMM/uuuu");
        //Convert String to LocalDateTime
        LocalDateTime ldt = LocalDateTime.parse(LocalDateTime.now().toString(), ISO_LOCAL_DATE_TIME);
        day.setText(format.format(ldt));

    }

    public void loadRoot(Page page) {
        AnchorPane root = Handler.getRoot(page);
        Handler.getController(page).init();
        CurrentData.currentPage = page;
        int num = mainanchor.getChildren().size();
        if (page==Page.IDINFOLOGIN||page==Page.BOOKNUMLOGIN||page==Page.IDCARDLOGIN){
            back.setVisible(false);
        }else if(page==Page.LASTPAGE){
            back.setVisible(false);
            exit.setVisible(false);
            help.setVisible(false);
        }else{
            back.setVisible(true);
        }
        mainanchor.getChildren().remove(num-1);
        mainanchor.getChildren().add(root);
    }


    @FXML
    public void exit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to exit?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Exit");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==ButtonType.YES){
            System.exit(0);
        }

    }


    @FXML
    public void help(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help Information");
        alert.setHeaderText("Customer Service Hotline");
        alert.setContentText("1234 - 5678960");
        Optional<ButtonType> result = alert.showAndWait();
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
