package com.example.javafxdemo.controller.login;

import com.example.javafxdemo.controller.*;
import com.example.javafxdemo.utils.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
/**
 * Class InputIdController is used to control input-id.fxml
 * which for inputting the surname and ID number
 *
 * @author dxzSabrina
 * @version 1.0
 */
public class InputIdController implements Controller {
    /**
     * the confirmation button of inputting the information
     */
    @FXML
    private Button confirmInput;
    /**
     * the hyperlink to hello-view.fxml
     */
    @FXML
    private Hyperlink booknum;
    /**
     * the hyperlink to scan-id.fxml on helloanchor
     */
    @FXML
    private Hyperlink upload;
    /**
     * the textfield to input surname
     */
    @FXML
    private TextField surname;
    /**
     * the textfield to input ID number
     */
    @FXML
    private TextField idnumber;

    /**
     * constructor
     */
    public InputIdController() {
    }

    /**
     * init() is used to initialize.
     */
    @Override
    public void init(){
        idnumber.setTextFormatter(new TextFormatter<String>(new IntegerFilter()));
        surname.setTextFormatter(new TextFormatter<String>(new IntegerStringFilter()));
    }

    /**
     * onClickConfirmInput() is used to react to the click of confirm button.
     * If the id number and name is correct, it will fetch the information.
     * If the id number and name cannot be found, it will alert.
     */
    @FXML
    public void onClickConfirmInput(){
        try {
            String name = surname.getText().trim();
            String id = idnumber.getText().trim();
            UserData ud = Utils.login(name,id);
            Utils.loginCheck(ud,"No relative information! Please input again!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * inputBooknum() is used to get to the hello-view.fxml after clicking hyperlink.
     */
    @FXML
    public void inputBooknum(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.BOOKNUMLOGIN);
    }
    /**
     * uploadId() is used to get to the scan-id.fxml after clicking hyperlink.
     */
    @FXML
    public void uploadId(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.IDCARDLOGIN);
    }


}