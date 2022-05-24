package com.example.javafxdemo.controller.FirstPage;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
/**
 * Class FirstPageController is used to control first-page.fxml
 * which is the first page of the system
 *
 * @author ??
 * @version 1.0
 */
public class FirstPageController implements Controller {

    /**
     * init() is used to initialize.
     */
    @Override
    public void init() {

    }

    /**
     * onClickButton() is used to react to the click of confirm button.
     * Once clicked, user enters the system.
     */
    @FXML
    public void onClickButton(){
        AnchorPane root = Handler.getRoot(Page.MAIN);
        Controller main = Handler.getController(Page.MAIN);
        Handler.stage.getScene().setRoot(root);
        main.init();
    }


}
