package com.example.javafxdemo.utils;

import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.control.Alert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Utils {
    public static UserData login(String... args){
        int argc = args.length;
        File file = new File(ClassPath.classPath+"Data.json"); //Json
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader(file));
            JsonArray array = object.get("UserData").getAsJsonArray();
            if (argc==1){
                String booknum = args[0];
                for (int i = 0; i < array.size(); i++) {
                    JsonObject subObject = array.get(i).getAsJsonObject();
                    String number = subObject.get("bookingNum").getAsString();
                    if (booknum.equals(number)) {
                        Gson gson = new Gson();
                        return gson.fromJson(subObject,UserData.class);
                    }
                }
            }else if (argc==2){
                String name = args[0];
                String id = args[1];
                for (int i = 0; i < array.size(); i++) {
                    JsonObject subObject = array.get(i).getAsJsonObject();
                    String nameInFile = subObject.get("firstname").getAsString()+" "+subObject.get("surname").getAsString();
                    String idInFile = subObject.get("id").getAsString();
                    if (name.equals(nameInFile)&&id.equals(idInFile)) {
                        Gson gson = new Gson();
                        return gson.fromJson(subObject,UserData.class);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loginCheck(UserData ud, String msg){
        Alert alert;
        if (ud==null){
            alert = new Alert(Alert.AlertType.ERROR, msg);
            alert.showAndWait();
        }else {
            System.out.println(ud.getBookingNum());
            alert = new Alert(Alert.AlertType.INFORMATION, "Check in successfully!");
            alert.showAndWait();
            CurrentData.userData = ud;
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.FIRSTVIEW);
        }
    }

    public static ArrayList<String> initialSeatPage(){
        ArrayList<String> occupiedSeat = new ArrayList<String>();
        File file = new File(ClassPath.classPath + CurrentData.userData.getFlightNum() + "_" + CurrentData.userData.getFlyingDate() + ".json"); //Json
        JsonParser parser = new JsonParser();
        JsonObject object;
        try {
            object = (JsonObject) parser.parse(new FileReader(file));
            JsonArray array = object.get("UserData").getAsJsonArray();
            for(int i = 0; i < array.size(); i++) {
                JsonObject subObject = array.get(i).getAsJsonObject();
                occupiedSeat.add(subObject.get("seatNum").getAsString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not exist");
        }finally {
            return occupiedSeat;
        }
    }

    /**
     * @param backgroundPath
     * @param message
     * @param outPutPath
     * @throws IOException
     */
    public static void overlapImage(String backgroundPath, String message, String outPutPath,int x,int y, int fontSize) throws IOException {
        overlapImage(backgroundPath, message, outPutPath, x, y, fontSize,Color.black);
    }


    public static void overlapImage(String backgroundPath, String message, String outPutPath,int x,int y, int fontSize,Color c) throws IOException{
        BufferedImage backgroundImage = ImageIO.read(new File(backgroundPath));
        Graphics2D graphics = backgroundImage.createGraphics();

        graphics.setColor(c);
        graphics.setFont(new Font("Calibri", Font.BOLD, fontSize));
        graphics.drawString(message, x, y);
        graphics.dispose();


        ImageIO.write(backgroundImage, "png", new File(outPutPath));
    }



    public static void printBoarding(String[] str) throws IOException {
        String backgroundPath = ClassPath.classPath+ "boarding.png";
        String outPutPath = ClassPath.classPath+ "user-boarding.png";

        Utils.overlapImage(backgroundPath, str[0], outPutPath,45,126,22);
        Utils.overlapImage(outPutPath, str[0], outPutPath,780,235,25);

        Utils.overlapImage(outPutPath, str[1], outPutPath,157,198,18);
        Utils.overlapImage(outPutPath, str[1], outPutPath,810,288,50);

        Utils.overlapImage(outPutPath, str[2], outPutPath,273,198,18);

        Utils.overlapImage(outPutPath, str[3], outPutPath,411,198,18);

//        Utils.overlapImage(outPutPath, str[4], outPutPath,426,218,18);

        Utils.overlapImage(outPutPath, str[5], outPutPath,539,198,18);
        Utils.overlapImage(outPutPath, str[5], outPutPath,822,130,18);


        Utils.overlapImage(outPutPath, str[6], outPutPath,215,290,18);
        Utils.overlapImage(outPutPath, str[6], outPutPath,826,154,18);

        Utils.overlapImage(outPutPath, str[7], outPutPath,420,290,18);
        Utils.overlapImage(outPutPath, str[7], outPutPath,806,173,18);


        Utils.overlapImage(outPutPath, str[8], outPutPath,780,70,24, new Color(0,162,162));
        Utils.overlapImage(outPutPath, str[8], outPutPath,93,259,20);
    }

    public static void printTag(String[] str) throws IOException{
        String backgroundPath = ClassPath.classPath+ "tag.png";
        String outPutPath = ClassPath.classPath+ "user-tag.png";
        Utils.overlapImage(backgroundPath, str[0], outPutPath,136,130,25);

        Utils.overlapImage(outPutPath, str[1], outPutPath,136,169,25);

        Utils.overlapImage(outPutPath, str[2], outPutPath,136,210,25);

    }
    public static void printTicket(String[] str) throws IOException{
        String backgroundPath = ClassPath.classPath+ "ticket.png";
        String outPutPath = ClassPath.classPath+ "user-ticket.png";
        Utils.overlapImage(backgroundPath, str[0], outPutPath,87,169,22);

        Utils.overlapImage(outPutPath, str[1], outPutPath,91,194,22);

        Utils.overlapImage(outPutPath, str[2], outPutPath,85,121,22);

        Utils.overlapImage(outPutPath, str[3], outPutPath,58,146,22);

    }

}
