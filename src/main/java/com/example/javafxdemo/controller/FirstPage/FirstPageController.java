package com.example.javafxdemo.controller.FirstPage;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class FirstPageController implements Controller {

    @Override
    public void init() {

    }

    @FXML
    public void onClickButton(){
        AnchorPane root = Handler.getRoot(Page.MAIN);
        Controller main = Handler.getController(Page.MAIN);
        Handler.stage.getScene().setRoot(root);
        main.init();
    }


}
