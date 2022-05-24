package com.example.javafxdemo.controller;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.utils.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.util.HashMap;

import static com.example.javafxdemo.utils.Page.*;

/**
 * Class Handler is used to provide fundamental FXMLLoaders
 * and connect them with pages.
 *
 * @author RongxiYe
 * @version 1.0
 */
public class Handler {
    private static HashMap<Page, FXMLLoader> loaders;

    /**
     * the stage of the whole program.
     */
    public static Stage stage;
    static{
        loaders = new HashMap<>();
        try{
            FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
            FXMLLoader firstPageLoader = new FXMLLoader(HelloApplication.class.getResource("first-page.fxml"));
            FXMLLoader helloLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            FXMLLoader uploadLoader = new FXMLLoader(HelloApplication.class.getResource("scan-id.fxml"));
            FXMLLoader inputLoader = new FXMLLoader(HelloApplication.class.getResource("input-id.fxml"));
            FXMLLoader firstViewLoader = new FXMLLoader(HelloApplication.class.getResource("first-view.fxml"));
            FXMLLoader printLoader = new FXMLLoader(HelloApplication.class.getResource("checkin-view.fxml"));
            FXMLLoader seatLoader = new FXMLLoader(HelloApplication.class.getResource("seat-select.fxml"));
            FXMLLoader mealLoader = new FXMLLoader(HelloApplication.class.getResource("meal-select.fxml"));
            FXMLLoader smConfirmLoader = new FXMLLoader(HelloApplication.class.getResource("sm-confirm.fxml"));
            FXMLLoader helpInfoLoader = new FXMLLoader(HelloApplication.class.getResource("help-info.fxml"));
            FXMLLoader creditinfoLoader = new FXMLLoader(HelloApplication.class.getResource("credit-info.fxml"));
            FXMLLoader lastLoader = new FXMLLoader(HelloApplication.class.getResource("last-page.fxml"));

            firstPageLoader.load();
            mainLoader.load();
            helloLoader.load();
            inputLoader.load();
            firstViewLoader.load();
            seatLoader.load();
            printLoader.load();
            uploadLoader.load();
            mealLoader.load();
            smConfirmLoader.load();
            helpInfoLoader.load();
            creditinfoLoader.load();
            lastLoader.load();

            loaders.put(FIRSTPAGE, firstPageLoader);
            loaders.put(MAIN, mainLoader);
            loaders.put(BOOKNUMLOGIN, helloLoader);
            loaders.put(IDINFOLOGIN, inputLoader);
            loaders.put(CHECKINVIEW, printLoader);
            loaders.put(SEATSELECT, seatLoader);
            loaders.put(IDCARDLOGIN, uploadLoader);
            loaders.put(MEALSELECT, mealLoader);
            loaders.put(SMCONFIRM, smConfirmLoader);
            loaders.put(HELPINFO, helpInfoLoader);
            loaders.put(CREDITINFO, creditinfoLoader);
            loaders.put(FIRSTVIEW,firstViewLoader);
            loaders.put(LASTPAGE,lastLoader);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * getPage() is used to return the current page.
     *
     * @param page the corresponding Page enum of the page.
     * @return the corresponding Page enum of the page.
     */
    public static FXMLLoader getPage(Page page){
        return loaders.get(page);
    }

    /**
     * getRoot() is used to return the root of the current page.
     *
     * @param page the corresponding Page enum of the page.
     * @return the corresponding root of the page.
     */
    public static AnchorPane getRoot(Page page){
        return loaders.get(page).getRoot();
    }

    /**
     * getController() is used to return the controller of the current page.
     *
     * @param page the corresponding Page enum of the page.
     * @return the corresponding controller of the page.
     */
    public static Controller getController(Page page){
        return loaders.get(page).getController();
    }

}
