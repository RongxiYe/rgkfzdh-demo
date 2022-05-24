/**
 * Provides all controllers and handler they use.
 */

package com.example.javafxdemo.controller;

import javafx.scene.control.*;
import javafx.scene.text.Text;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

/**
 * Class MainController is used to control main.fxml and
 * load other fxml file as root in AnchorPane.
 *
 * @author RongxiYe
 * @version 1.0
 */
public class MainController implements Controller{

    /**
     * the main anchor pane in the stage
     */
    @FXML
    public AnchorPane mainanchor;
    /**
     * the exit button on main anchor
     */
    public Button exit;
    /**
     * the help button on main anchor
     */
    public Button help;
    /**
     * the back button on main anchor
     */
    public Button back;
    /**
     * the date label on main anchor
     */
    public Label day;


    /**
     * init() is used to initialize main.fxml and load hello-view.fxml.
     * It also gets local date time and shows it.
     * At the beginning, the back button is set invisible.
     */
    public void init(){
        AnchorPane root = Handler.getRoot(Page.BOOKNUMLOGIN);
        Controller hello = Handler.getController(Page.BOOKNUMLOGIN);
        hello.init();
        mainanchor.getChildren().add(root);
        int num = mainanchor.getChildren().size();
        mainanchor.getChildren().get(num-2).setVisible(false);

        //date
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        //Convert String to LocalDateTime
        LocalDateTime ldt = LocalDateTime.parse(LocalDateTime.now().toString(), ISO_LOCAL_DATE_TIME);
        day.setText(format.format(ldt));

    }

    /**
     * loadRoot() is used to load a Page on main anchor pane.
     * It calls the init() func of controller to initialize the page.
     *
     * @param page the corresponding Page enum of the page.
     */
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


    /**
     * exit() is for exiting the program whenever user wants.
     */
    @FXML
    public void exit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to exit?");
        ButtonType buttonConfirm = new ButtonType("Yes", ButtonBar.ButtonData.NEXT_FORWARD);
        ButtonType buttonModify = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonConfirm, buttonModify);
        alert.setHeaderText("Exit");
        alert.setTitle("Exit");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==buttonConfirm){
            System.exit(0);
        }
    }


    /**
     * help() generates an alert and show the help information.
     */
    @FXML
    public void help(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help Information");
        alert.setHeaderText("Customer Service Hotline");
        alert.setContentText("1234 - 5678960");
        ButtonType buttonModify = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonModify);
        alert.showAndWait();
    }

    /**
     * back() is used to load the former page of one page.
     * The order is defined in Page enum.
     */
    @FXML
    public void back(){
        Page lastPage = CurrentData.currentPage.back();
        if (lastPage==null){
            System.out.println("Error!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Cannot go back!");
            ButtonType buttonModify = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonModify);
            alert.show();
        }else{
            loadRoot(lastPage);
        }
    }

}
