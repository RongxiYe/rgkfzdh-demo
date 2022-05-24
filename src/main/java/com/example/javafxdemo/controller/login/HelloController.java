package com.example.javafxdemo.controller.login;

import com.example.javafxdemo.controller.*;
import com.example.javafxdemo.utils.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

/**
 * Class HelloController is used to control hello-view.fxml
 * which for inputting booking number
 *
 * @author RongxiYe
 * @version 1.0
 */
public class HelloController implements Controller {
    /**
     * the helloanchor pane in the stage
     */
    public AnchorPane helloanchor;
    /**
     * the textfield on helloanchor
     */
    @FXML
    private TextField bn;
    /**
     * the hyperlink to scan-id.fxml on helloanchor
     */
    @FXML
    private Hyperlink upload;
    /**
     * the hyperlink to input-id.fxml on helloanchor
     */
    @FXML
    private Hyperlink inputID;

    /**
     * init() is used to initialize.
     */
    @Override
    public void init() {
        bn.setTextFormatter(new TextFormatter<String>(new IntegerFilter()));
    }

    /**
     * onClickCheckInButton() is used to react to the click of confirm button.
     * If input is empty, it will alert.
     * If input number does not exist, it will alert wrong number.
     */
    @FXML
    protected void onClickCheckInButton() {
        String booknum = bn.getText().trim();
        Alert alert;
        if (booknum.isEmpty() || booknum == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Empty input! Please input something!");
            ButtonType buttonCancel = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonCancel);
            alert.setHeaderText("Error!");
            alert.setTitle("Error");
            alert.showAndWait();
            System.out.println("empty");
        } else {
            UserData ud = Utils.login(booknum);
            Utils.loginCheck(ud,"Wrong booking number! Please input again");
        }
    }

    /**
     * uploadId() is used to get to the scan-id.fxml after clicking hyperlink.
     */
    @FXML
    protected void uploadId(){
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDCARDLOGIN);
    }
    /**
     * inputId() is used to get to the input-id.fxml after clicking hyperlink.
     */
    @FXML
    protected void inputID(){
        MainController main = (MainController)Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDINFOLOGIN);
    }
}