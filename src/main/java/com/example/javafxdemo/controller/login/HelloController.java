package com.example.javafxdemo.controller.login;

import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.controller.user.PrintPageController;
import com.example.javafxdemo.controller.user.SeatController;
import com.example.javafxdemo.data.UserData;
import com.example.javafxdemo.utils.ClassPath;
import com.google.gson.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class HelloController {
    @FXML
    private TextField bn;
    public AnchorPane helloanchor;
    private FXMLLoader[] loaders;
    private UserData userData;

    public void init(UserData data, FXMLLoader[] loaders) {
        this.userData = data;
        this.loaders = loaders;
    }

    @FXML
    protected void onClickCheckInButton() throws IOException {
        String booknum = bn.getText().trim();
        Alert alert;
        if (booknum.isEmpty() || booknum == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Empty input! Please input something!");
            alert.showAndWait();
            System.out.println("empty");

        } else {
            //search in file for user information
            //if there exist a user, do something
            //do not forget to change the condition of if clause
            String charset = "utf-8";
            File file = new File(ClassPath.classPath+"Data.json"); //Json
            long fileByteLength = file.length();
            byte[] content = new byte[(int) fileByteLength];
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                fileInputStream.read(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String str = null;
            try {
                str = new String(content, charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                JsonParser parser = new JsonParser();
                JsonObject object = (JsonObject) parser.parse(new FileReader(file));
                JsonArray array = object.get("UserData").getAsJsonArray();
                int n = 0;
                for (int i = 0; i < array.size(); i++) {
                    n++;
                    JsonObject subObject = array.get(i).getAsJsonObject();
                    String number = subObject.get("bookingNum").getAsString();
                    if (booknum.equals(number)) {
                        System.out.println(booknum);
                        alert = new Alert(Alert.AlertType.INFORMATION, "Check in successfully!");
                        alert.showAndWait();
                        //给userData赋值
                        Gson gson = new Gson();
                        userData = gson.fromJson(subObject,UserData.class);
                        //
                        SeatController sc = loaders[3].getController();
                        sc.init(userData, loaders);
                        MainController main = loaders[0].getController();
                        main.loadRoot(loaders[3]);
                        break;
                    }
                }
                if (n >= array.size()+1) {
                    alert = new Alert(Alert.AlertType.ERROR, "Wrong booking number! Please input again");
                    alert.showAndWait();
                }

            } catch (JsonIOException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

}