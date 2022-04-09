package com.example.javafxdemo.data;

import java.util.Date;

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
    private String carryOn;

    public String getCarryOn() {
        return carryOn;
    }

    public void setCarryOn(String carryOn) {
        this.carryOn = carryOn;
    }

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
        this.carryOn = null;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getFlyingDate() {
        return flyingDate;
    }

    public void setFlyingDate(String flyingDate) {
        this.flyingDate = flyingDate;
    }

    public String getDepAddr() {
        return depAddr;
    }

    public void setDepAddr(String depAddr) {
        this.depAddr = depAddr;
    }

    public String getDesAddr() {
        return desAddr;
    }

    public void setDesAddr(String desAddr) {
        this.desAddr = desAddr;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getDelayStatus() {
        return delayStatus;
    }

    public void setDelayStatus(String delayStatus) {
        this.delayStatus = delayStatus;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }
}