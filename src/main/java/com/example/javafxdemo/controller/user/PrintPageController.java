package com.example.javafxdemo.controller.user;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.data.CurrentData;
import com.example.javafxdemo.utils.ClassPath;
import com.example.javafxdemo.utils.PrintProgress;
import com.example.javafxdemo.utils.UserData;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * Class PrintPageController is used to control checkin-view.fxml and
 * it helps to print out the ticket of the user with all informations.
 *
 * @author dxzSabrina, RongxiYe
 * @version 1.0
 */
public class PrintPageController implements Controller {

    /**
     * the Airline Information label on main anchor
     */
    @FXML
    public Label airLineInfo;

    /**
     * the Extra Payment label on main anchor
     */
    public Label extraPay;

    /**
     * the invisible payment label on main anchor which show prices of seat and meal
     */
    public Label payment;

    /**
     * the main anchor pane in the stage
     */
    public AnchorPane checkinanchor;

    /**
     * the PRINT YOUR MATERIALS button on main anchor
     */
    public Button confirmCheckIn;


    /**
     * init() is used to initially load the fist appearance of the page on main anchor pane.
     * It displays all flight info including payment of seat and meal on the page.
     */
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

    /**
     * onClickPrintMaterialButton() is used to generate a confirmation alert box for user to refer to.
     * It asks the user whether or not to print the page.
     */
    @FXML
    protected void onClickPrintMaterialButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType buttonConfirm = new ButtonType("Yes", ButtonBar.ButtonData.NEXT_FORWARD);
        ButtonType buttonModify = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonConfirm, buttonModify);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure to print all your materials?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()==buttonConfirm){
            PrintProgress.show();
            PrintProgress.printInfo();
            sendToBack();
        }
    }

    /**
     * sendToBack() is used to print out all information(write information of the user in to a file).
     * The file is of json format.
     */
    public void sendToBack(){
        try {
            JsonParser parser = new JsonParser();
            Gson gson = new Gson();
            String udata = gson.toJson(CurrentData.userData);
            JsonObject subObject = parser.parse(udata).getAsJsonObject();

            File file=new File("./"+CurrentData.userData.getFlightNum()+"_"+CurrentData.userData.getFlyingDate()+".json");
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
                        array.remove(jo);
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

            BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            bufferedWriter.write(object.toString());
            bufferedWriter.flush();//
            bufferedWriter.close();//

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
