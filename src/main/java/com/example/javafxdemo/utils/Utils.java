package com.example.javafxdemo.utils;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * Defines the format of the database
 * Defines the login screen and the output of the print-out screen.
 *
 * @author RongxiYe
 * @version 1.0
 */
public class Utils {
    /**
     * Write the data into the Data.json file
     * and arrange them neatly in a fixed format for easy viewing
     *
     * @param args This data represents the Xth array of data in the Data.json file
     * @return Returns a string converted to a JAVA entity class
     */
    public static UserData login(String... args){
        int argc = args.length;
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new InputStreamReader(HelloApplication.class.getResourceAsStream("/com/example/javafxdemo/Data.json")));
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
                    String nameInFile = subObject.get("surname").getAsString();
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

    /**
     * When logging in by entering bookingNum, determine if the bookingNum entered at login is correct
     *
     * @param ud The value of a particular set of data in the database
     * @param msg Prompt in alert when login error occurs
     */
    public static void loginCheck(UserData ud, String msg){
        Alert alert;
        if (ud==null){
            alert = new Alert(Alert.AlertType.ERROR, msg);
            ButtonType buttonCancel = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonCancel);
            alert.setHeaderText("Error!");
            alert.setTitle("Error");
            alert.showAndWait();
        }else {
            System.out.println(ud.getBookingNum());
            alert = new Alert(Alert.AlertType.INFORMATION, "Check in successfully!");
            ButtonType buttonCancel = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonCancel);
            alert.setHeaderText("OK");
            alert.setTitle("OK");
            alert.showAndWait();
            CurrentData.userData = ud;
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.FIRSTVIEW);
        }
    }

    /**
     * Generate a file with flight information
     *
     * @return Return the seat code of the selected seat
     */
    public static ArrayList<String> initialSeatPage(){
        ArrayList<String> occupiedSeat = new ArrayList<String>();
        File file = new File(ClassPath.classPath + CurrentData.userData.getFlightNum() + "_" + CurrentData.userData.getFlyingDate() + ".json"); //Json
        JsonParser parser = new JsonParser();
        JsonObject object;
        try {
            object = (JsonObject) parser.parse(new InputStreamReader(HelloApplication.class.getResourceAsStream("/com/example/javafxdemo/"+ CurrentData.userData.getFlightNum() + "_" + CurrentData.userData.getFlyingDate() + ".json")));
            JsonArray array = object.get("UserData").getAsJsonArray();
            for(int i = 0; i < array.size(); i++) {
                JsonObject subObject = array.get(i).getAsJsonObject();
                occupiedSeat.add(subObject.get("seatNum").getAsString());
            }
        } catch (Exception e) {
            System.out.println("File not exist");
        }finally {
            return occupiedSeat;
        }
    }

    /**
     * Creating a page background using String
     *
     * @param backgroundPath Path to the background image
     * @param message Text message on page
     * @param outPutPath Output path
     * @param x x width
     * @param y y height
     * @param fontSize font size
     * @throws IOException Image failed to load
     */
    public static void overlapImage(URL backgroundPath, String message, String outPutPath,int x,int y, int fontSize) throws IOException {
        overlapImage(backgroundPath, message, outPutPath, x, y, fontSize,Color.black);
    }
    /**
     * Creating a page background using URL
     *
     * @param backgroundPath Path to the background image
     * @param message Text message on page
     * @param outPutPath Output path
     * @param x x width
     * @param y y height
     * @param fontSize font size
     * @throws IOException Image failed to load
     */
    public static void overlapImage(String backgroundPath, String message, String outPutPath,int x,int y, int fontSize) throws IOException {
        overlapImage(backgroundPath, message, outPutPath, x, y, fontSize,Color.black);
    }

    /**
     * Creating a page background
     *
     * @param backgroundPath Path to the background image
     * @param message Text message on page
     * @param outPutPath Output path
     * @param x Width
     * @param y Length
     * @param fontSize Font size
     * @param c color
     * @throws IOException when image failed to load
     */
    public static void overlapImage(URL backgroundPath, String message, String outPutPath, int x, int y, int fontSize, Color c) throws IOException{
        BufferedImage backgroundImage = ImageIO.read(backgroundPath);
        Graphics2D graphics = backgroundImage.createGraphics();

        graphics.setColor(c);
        graphics.setFont(new Font("Calibri", Font.BOLD, fontSize));
        graphics.drawString(message, x, y);
        graphics.dispose();


        ImageIO.write(backgroundImage, "png", new File(outPutPath));
    }


    /**
     * a overload method for overlap image
     * @param backgroundPath path of background
     * @param message message to print
     * @param outPutPath path of output image
     * @param x x width
     * @param y y height
     * @param fontSize size of font
     * @param c color
     * @throws IOException when there are any exceptions
     */
    public static void overlapImage(String backgroundPath, String message, String outPutPath, int x, int y, int fontSize, Color c) throws IOException{
        BufferedImage backgroundImage = ImageIO.read(new File(backgroundPath));
        Graphics2D graphics = backgroundImage.createGraphics();
        graphics.setColor(c);
        graphics.setFont(new Font("Calibri", Font.BOLD, fontSize));
        graphics.drawString(message, x, y);
        graphics.dispose();


        ImageIO.write(backgroundImage, "png", new File(outPutPath));
    }

    /**
     * Print the user's detailed flight data on the boarding.png
     *
     * @param str An array in the database
     * @throws IOException Error loading images or data
     */
    public static void printBoarding(String[] str) throws IOException {
        URL backgroundPath = HelloApplication.class.getResource("/com/example/javafxdemo/boarding.png");
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

    /**
     * Print the user's detailed flight data on the tag.png
     *
     * @param str An array in the database
     * @throws IOException Error loading images or data
     */
    public static void printTag(String[] str) throws IOException{
        URL backgroundPath = HelloApplication.class.getResource("/com/example/javafxdemo/tag.png");
        String outPutPath = ClassPath.classPath+ "user-tag.png";
        Utils.overlapImage(backgroundPath, str[0], outPutPath,136,130,25);

        Utils.overlapImage(outPutPath, str[1], outPutPath,136,169,25);

        Utils.overlapImage(outPutPath, str[2], outPutPath,136,210,25);

    }

    /**
     * Print the user's detailed flight data on the ticket.png
     *
     * @param str An array in the database
     * @throws IOException Error loading images or data
     */
    public static void printTicket(String[] str) throws IOException{
        URL backgroundPath = HelloApplication.class.getResource("/com/example/javafxdemo/ticket.png");
        String outPutPath = ClassPath.classPath+ "user-ticket.png";
        Utils.overlapImage(backgroundPath, str[0], outPutPath,87,169,22);

        Utils.overlapImage(outPutPath, str[1], outPutPath,91,194,22);

        Utils.overlapImage(outPutPath, str[2], outPutPath,85,121,22);

        Utils.overlapImage(outPutPath, str[3], outPutPath,58,146,22);

    }

}

