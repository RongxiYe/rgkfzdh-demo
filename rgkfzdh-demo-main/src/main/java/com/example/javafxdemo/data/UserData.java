package com.example.javafxdemo.data;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserData {
    private String bookingNum;
    private String surname;
    private String firstname;
    private String flightNum;
    private String seatNum;
    private String meal;
    private String flyingDate;
    private String depAddr;
    private String desAddr;
    private String totalTime;
    private String delayStatus;
    private String luggage;

    public UserData(){
        this.bookingNum = null;
        this.surname = null;
        this.firstname = null;
        this.flightNum = null;
        this.seatNum = null;
        this.meal = null;
        this.flyingDate = null;
        this.depAddr = null;
        this.desAddr = null;
        this.totalTime = null;
        this.delayStatus = null;
        this.luggage = null;
    }

    public String getBookingNum() {
        try {

            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;//暂时设成1；应该从HelloController传参（输入的booknum）过来
                JsonObject subObject = array.get(i).getAsJsonObject();
                bookingNum = subObject.get("bookingNum").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bookingNum;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }

    public String getSurname() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            surname = subObject.get("surname").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            firstname = subObject.get("firstname").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFlightNum() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            flightNum = subObject.get("flightNum").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getSeatNum() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            seatNum = subObject.get("seatNum").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getMeal() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            meal = subObject.get("meal").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getFlyingDate() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            flyingDate = subObject.get("flyingDate").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flyingDate;
    }

    public void setFlyingDate(String flyingDate) {
        this.flyingDate = flyingDate;
    }

    public String getDepAddr() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            depAddr = subObject.get("depAddr").getAsString();
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return depAddr;
    }

    public void setDepAddr(String depAddr) {
        this.depAddr = depAddr;
    }

    public String getDesAddr() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            desAddr = subObject.get("desAddr").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return desAddr;
    }

    public void setDesAddr(String desAddr) {
        this.desAddr = desAddr;
    }

    public String getTotalTime() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            totalTime = subObject.get("totalTime").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getDelayStatus() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            delayStatus = subObject.get("delayStatus").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return delayStatus;
    }

    public void setDelayStatus(String delayStatus) {
        this.delayStatus = delayStatus;
    }

    public String getLuggage() {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("Data.json"));
            JsonArray array = object.get("UserData").getAsJsonArray();
            int i = 1;
            JsonObject subObject = array.get(i).getAsJsonObject();
            luggage = subObject.get("luggage").getAsString();

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }
}