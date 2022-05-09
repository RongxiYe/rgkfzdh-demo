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
                        //给userData赋值
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
                        //给userData赋值
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
            //给userData赋值
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
    public static void overlapImage(String backgroundPath, String message, String outPutPath,int x,int y) throws IOException {

        BufferedImage backgroundImage = resizeImage(941, 331, ImageIO.read(new File(backgroundPath)));
        Graphics2D graphics = backgroundImage.createGraphics();

        graphics.setColor(Color.black);
        graphics.setFont(new Font("Calibri", Font.BOLD, 22));
        graphics.drawString(message, x, y);
        graphics.dispose();

        // 输出新的图片
        ImageIO.write(backgroundImage, "png", new File(outPutPath));
    }

    /**
     * resize image
     *
     * @param width
     * @param height
     * @param bufferedImage
     * @return
     */
    private static BufferedImage resizeImage(int width, int height, BufferedImage bufferedImage) {
        BufferedImage newBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        newBufferedImage.getGraphics().drawImage(bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        return newBufferedImage;
    }

}
