package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.data.UserData;
import com.example.javafxdemo.utils.ClassPath;
import com.example.javafxdemo.utils.Tool;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
//        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
//        String date = formatter.format(userData.getFlyingDate());
        String date = userData.getFlyingDate();
        String po = userData.getDelayStatus();
        String cg = userData.getLuggage();

        //payment 打印
        String stn = userData.getSeatNum();
        String ml = userData.getMeal();
        String co = userData.getCarryOn();

        String string1 = bn+"\n"+"\n"+sn+"\n"+"\n"+an+"\n"+"\n"+date+"\n"+"\n"+po+"\n"+"\n"+cg+"\n\n"+co;
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
            Gson gson = new Gson();
            String udata = gson.toJson(userData);
            JsonObject subObject = parser.parse(udata).getAsJsonObject();

            File file=new File(ClassPath.classPath+userData.getFlightNum()+"_"+userData.getFlyingDate()+".json");
            if(!file.exists()) //判断文件是否存在，若不存在则新建
            {
                file.createNewFile();
            }

            JsonObject object;
            try{
                object = gson.fromJson(new JsonReader(new FileReader(file, StandardCharsets.UTF_8)),JsonObject.class);
                JsonArray array = object.get("UserData").getAsJsonArray();
                System.out.println(array);
                array.add(subObject);
                object.add("UserData", array);
            }catch (Exception e){
                object = new JsonObject();
                JsonArray array = new JsonArray();
                array.add(subObject);
                object.add("UserData", array);
                System.out.println(array);
            }

            BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));//创建字符缓冲输出流对象
            bufferedWriter.write(object.toString());//将格式化的subObject字符串写入文件
            bufferedWriter.flush();//清空缓冲区，强制输出数据
            bufferedWriter.close();//关闭输出流

//            String jsonString=subObject.toString();//将subObject转化为字符串
//            String JsonString=tool.stringToJSON(jsonString);//将subObject字符串格式化

        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
