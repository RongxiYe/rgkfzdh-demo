package com.example.javafxdemo.controller;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


import java.util.HashMap;

import static com.example.javafxdemo.utils.Page.*;

public class Handler {
    private static HashMap<Page, FXMLLoader> loaders;
    static{
        loaders = new HashMap<>();
        try{
            FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
            FXMLLoader helloLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            FXMLLoader printLoader = new FXMLLoader(HelloApplication.class.getResource("checkin-view.fxml"));
            FXMLLoader seatLoader = new FXMLLoader(HelloApplication.class.getResource("seat-select.fxml"));

            mainLoader.load();
            helloLoader.load();
            seatLoader.load();
            printLoader.load();

            loaders.put(MAIN,mainLoader);
            loaders.put(BOOKNUMLOGIN,helloLoader);
            loaders.put(CHECKINVIEW,printLoader);
            loaders.put(SEATSELECT,seatLoader);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static FXMLLoader getPage(Page page){
        return loaders.get(page);
    }
    public static AnchorPane getRoot(Page page){
        return loaders.get(page).getRoot();
    }
    public static Controller getController(Page page){
        return loaders.get(page).getController();
    }

}
