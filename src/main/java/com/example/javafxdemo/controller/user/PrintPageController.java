package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.ClassPath;
import com.example.javafxdemo.utils.PrintProgress;
import com.example.javafxdemo.utils.UserData;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PrintPageController implements Controller {
    @FXML
    public Label airLineInfo;
    public Label extraPay;
    public Label payment;
    public AnchorPane checkinanchor;
    public Button confirmCheckIn;



    public void init(){
        UserData userData = CurrentData.userData;

        //airline information 打印
        String bn = userData.getBookingNum();
        String sn = userData.getSurname();
        String an = userData.getFlightNum();

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
        if(ml.equals("Set Meal") && stn.charAt(1) == '1'){
            String pays = "50$";
            String paym = "5$";
            String stringpay = pays + "\n" + "\n" + "\n" + paym;
            payment.setText(stringpay);
        }else if((!ml.equals("Set Meal")) && stn.charAt(1) == '1'){
            String pays = "50$";
            String paym = "0$";
            String stringpay = pays + "\n" + "\n" + "\n" + paym;
            payment.setText(stringpay);
        }else if(ml.equals("Set Meal")  && stn.charAt(1) != '1'){
            String pays = "0$";
            String paym = "5$";
            String stringpay = pays + "\n" + "\n" + "\n" + paym;
            payment.setText(stringpay);
        }else{
            String pays = "0$";
            String paym = "0$";
            String stringpay = pays + "\n" + "\n" + "\n" + paym;
            payment.setText(stringpay);
        }
    }

    @FXML
    protected void onClickPrintMaterialButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure to print all your materials?");
        alert.showAndWait();

        //打印出信息文件
        //生成发给后台系统的文件
        PrintProgress.show();
        PrintProgress.printInfo();
        sendToBack();

    }

    public void sendToBack(){
        try {
            JsonParser parser = new JsonParser();
            Gson gson = new Gson();
            String udata = gson.toJson(CurrentData.userData);
            JsonObject subObject = parser.parse(udata).getAsJsonObject();

            File file=new File(ClassPath.classPath+CurrentData.userData.getFlightNum()+"_"+CurrentData.userData.getFlyingDate()+".json");
            if(!file.exists()) //判断文件是否存在，若不存在则新建
            {
                file.createNewFile();
            }

            JsonObject object;
            try{
                object = gson.fromJson(new JsonReader(new FileReader(file, StandardCharsets.UTF_8)),JsonObject.class);
                JsonArray array = object.get("UserData").getAsJsonArray();
//                System.out.println(array);
                for(JsonElement jo :array){
                    if(jo.getAsJsonObject().get("bookingNum").getAsString().equals(CurrentData.userData.getBookingNum())){
                        break;
                    }
                }
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
