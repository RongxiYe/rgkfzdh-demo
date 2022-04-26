package com.example.javafxdemo.controller;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.util.HashMap;

import static com.example.javafxdemo.utils.Page.*;

public class Handler {
    private static HashMap<Page, FXMLLoader> loaders;
    public static Stage stage;
    static{
        loaders = new HashMap<>();
        try{
            FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
            FXMLLoader helloLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            FXMLLoader uploadLoader = new FXMLLoader(HelloApplication.class.getResource("scan-id.fxml"));
            FXMLLoader printLoader = new FXMLLoader(HelloApplication.class.getResource("checkin-view.fxml"));
            FXMLLoader seatLoader = new FXMLLoader(HelloApplication.class.getResource("seat-select.fxml"));
            FXMLLoader mealLoader = new FXMLLoader(HelloApplication.class.getResource("meal-select.fxml"));
            FXMLLoader smConfirmLoader = new FXMLLoader(HelloApplication.class.getResource("sm-confirm.fxml"));

            mainLoader.load();
            helloLoader.load();
            seatLoader.load();
            printLoader.load();
            uploadLoader.load();
            mealLoader.load();
            smConfirmLoader.load();

            loaders.put(MAIN,mainLoader);
            loaders.put(BOOKNUMLOGIN,helloLoader);
            loaders.put(CHECKINVIEW,printLoader);
            loaders.put(SEATSELECT,seatLoader);
            loaders.put(IDCARDLOGIN,uploadLoader);
            loaders.put(MEALSELECT,mealLoader);
            loaders.put(SMCONFIRM,smConfirmLoader);

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
