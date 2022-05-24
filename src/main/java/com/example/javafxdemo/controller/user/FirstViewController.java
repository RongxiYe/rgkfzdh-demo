package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class FirstViewController implements Controller {
    @FXML
    public AnchorPane firstViewAnchor;
    public Label infoContent;
    public Button fvConfirm;

    public void init(){
        UserData userData = CurrentData.userData;
        //airline information 打印
        String sn = userData.getSurname();
        String fn = userData.getFirstname();
        String an = userData.getFlightNum();
        String dep = userData.getDepAddr();

        String date = userData.getFlyingDate();
        String po = userData.getDelayStatus();
        String cg = userData.getCarryOn();
        String bg = userData.getLuggage();

        String des = userData.getDesAddr();

        String string1 = sn+"\n"+"\n"+fn+"\n"+"\n"+an+
                "\n"+"\n"+dep+"\n"+"\n"+des+"\n"+"\n"
                +date+"\n"+"\n"+cg+"\n"+"\n"+bg+"\n"+"\n"+po;
        infoContent.setText(string1);

    }
    @FXML public void ConfirmButton(){
        //use loaders to enter the next page.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure the information is correct?"); //
        ButtonType buttonConfirm = new ButtonType("Yes", ButtonBar.ButtonData.NEXT_FORWARD);
        ButtonType buttonModify = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonConfirm, buttonModify);
        alert.setHeaderText("Confirmation");
        alert.setTitle("Confirmation");
        Optional<ButtonType> result = alert.showAndWait();
        MainController main = (MainController) Handler.getController(Page.MAIN);
        if(result.get()==buttonConfirm){
            main.loadRoot(Page.SEATSELECT);
        }

    }

}
