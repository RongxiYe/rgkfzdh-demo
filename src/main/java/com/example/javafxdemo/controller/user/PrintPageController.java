package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.data.UserData;
import com.example.javafxdemo.utils.ClassPath;
import com.example.javafxdemo.utils.Tool;
import com.google.gson.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.text.SimpleDateFormat;

public class PrintPageController {
    @FXML
    public Label airLineInfo;
    public Label extraPay;
    public AnchorPane checkinanchor;
    private UserData userData;
    private FXMLLoader[] loaders;

    public void init(UserData data, FXMLLoader[] loaders){
        this.userData = data;
        this.loaders = loaders;
        //airline information 打印
        String bn = userData.getBookingNum();
        String sn = userData.getSurname();
        String an = userData.getFlightNum();
        //目前日期没有值，无法转换格式
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        String date = formatter.format(userData.getFlyingDate());;
        String po = userData.getDelayStatus();
        String cg = userData.getLuggage();

        //payment 打印
        String stn = userData.getSeatNum();
        String ml = userData.getMeal();

        String string1 = bn+"\n"+"\n"+sn+"\n"+"\n"+an+"\n"+"\n"+date+"\n"+"\n"+po+"\n"+"\n"+cg;
        String string2 = stn+"\n"+"\n"+"\n"+ml;
        //airLineInfo和extraPay换行显示data
        airLineInfo.setText(string1);
        extraPay.setText(string2);
    }

    @FXML
    protected void onClickPrintMaterialButton() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure to print all your materials?");
        alert.showAndWait();

        //打印出信息文件
        //生成发给后台系统的文件

        Tool tool = new Tool();
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader(ClassPath.classPath+"Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;//先假定int=1，等前面传参过来
            JsonObject subObject = array.get(i).getAsJsonObject();

            File file=new File(ClassPath.classPath+"PrintPage.json");
            if(!file.exists()) //判断文件是否存在，若不存在则新建
            {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream=new FileOutputStream(file);//实例化FileOutputStream
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");//将字符流转换为字节流
            BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter);//创建字符缓冲输出流对象

            String jsonString=subObject.toString();//将subObject转化为字符串

            String JsonString=tool.stringToJSON(jsonString);//将subObject字符串格式化
            bufferedWriter.write(JsonString);//将格式化的subObject字符串写入文件
            bufferedWriter.flush();//清空缓冲区，强制输出数据
            bufferedWriter.close();//关闭输出流

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
