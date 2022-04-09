package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.IOException;

public class FirstViewController {
    @FXML
    public AnchorPane firstViewAnchor;
    private FXMLLoader[] loaders;
    private UserData userData;
    private FXMLLoader currentLoader;
    public Label infoContent;
    public Label destination;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
        //airline information 打印
        String bn = userData.getBookingNum();
        String sn = userData.getSurname();
        String fn = userData.getFirstname();
        String an = userData.getFlightNum();
        String dep = userData.getDepAddr();
        //目前日期没有值，无法转换格式
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        String date = formatter.format(userData.getFlyingDate());
        String po = userData.getDelayStatus();
        String cg = userData.getLuggage();

        //payment 打印
        String des = userData.getDesAddr();

        String string1 = sn+"\n"+"\n\n"+fn+"\n"+"\n"+an+"\n"+"\n"+dep+"\n"+"\n"+date+"\n"+"\n\n"+cg+"\n"+"\n\n"+po;
        String string2 = des;
        //airLineInfo和extraPay换行显示data
        infoContent.setText(string1);
        destination.setText(string2);
    }

}
