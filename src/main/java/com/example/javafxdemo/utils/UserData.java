package com.example.javafxdemo.utils;

/**
 * The class UserData is used to read data from the database and to store updated data into the database.
 * The get() method is used to read the data out of the database.
 * The set() method is used to store the new data into the database.
 *
 *  @author RongxiYe
 *  @version 1.0
 */
public class UserData {
    /**
     * booking number
     */
    private String bookingNum;
    /**
     * surname of user
     */
    private String surname;
    /**
     * first name of user
     */
    private String firstname;
    /**
     * id number of user
     */
    private String id;
    /**
     * flight number of user
     */
    private String flightNum;
    /**
     * seat of user
     */
    private String seatNum;
    /**
     * meal plan of user
     */
    private String meal;
    /**
     * the date of the flight of user
     */
    private String flyingDate;
    /**
     * departure address of user's flight
     */
    private String depAddr;
    /**
     * destination address of user's flight
     */
    private String desAddr;
    /**
     * total time of user's flight
     */
    private String totalTime;
    /**
     * delay status of user's flight
     */
    private String delayStatus;
    /**
     * check in luggage of user's flight
     */
    private String luggage;
    /**
     * carry on baggage of user's flight
     */
    private String carryOn;

    /**
     * Read the data of ID out of the database.
     *
     * @return Return the value of the ID
     */
    public String getId() {
        return id;
    }

    /**
     * Write the entered ID value to the database
     *
     * @param id Value of the entered ID
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Read the data of CarryOn out of the database.
     *
     * @return Return the value of the carryOn
     */
    public String getCarryOn() {
        return carryOn;
    }
    /**
     * Write the new carryOn value to the database
     *
     * @param carryOn Value of the new carryOn
     */
    public void setCarryOn(String carryOn) {
        this.carryOn = carryOn;
    }

    /**
     * UserData() method is used to initialize the database and set the initial value to null
     */
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
    /**
     * Read the data of bookingNum out of the database.
     *
     * @return Return the value of the bookingNum
     */
    public String getBookingNum() {
        return bookingNum;
    }
    /**
     * Write the entered bookingNum value to the database
     *
     * @param bookingNum Value of the entered bookingNum
     */
    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }
    /**
     * Read the data of surname out of the database.
     *
     * @return Return the value of the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Write the entered surname value to the database
     *
     * @param surname Value of the entered surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Read the data of firstname out of the database.
     *
     * @return Return the value of the firstname
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * Write the entered firstname value to the database
     *
     * @param firstname Value of the entered firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * Read the data of flightNum out of the database.
     *
     * @return Return the value of the flightNum
     */
    public String getFlightNum() {
        return flightNum;
    }
    /**
     * Write the new flightNum value to the database
     *
     * @param flightNum Value of the new flightNum
     */
    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }
    /**
     * Read the data of seatNum out of the database.
     *
     * @return Return the value of the seatNum
     */
    public String getSeatNum() {
        return seatNum;
    }
    /**
     * Write the new seatNum value to the database
     *
     * @param seatNum Value of the new seatNum
     */
    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }
    /**
     * Read the data of meal out of the database.
     *
     * @return Return the value of the meal
     */
    public String getMeal() {
        return meal;
    }
    /**
     * Write the new meal value to the database
     *
     * @param meal Value of the new meal
     */
    public void setMeal(String meal) {
        this.meal = meal;
    }
    /**
     * Read the data of flyingDate out of the database.
     *
     * @return Return the value of the flyingDate
     */
    public String getFlyingDate() {
        return flyingDate;
    }
    /**
     * Write the new flyingDate value to the database
     *
     * @param flyingDate New value of flyingDate
     */
    public void setFlyingDate(String flyingDate) {
        this.flyingDate = flyingDate;
    }
    /**
     * Read the data of depAddr out of the database.
     *
     * @return Return the value of the depAddr
     */
    public String getDepAddr() {
        return depAddr;
    }
    /**
     * Write the new depAddr value to the database
     *
     * @param depAddr Value of the new depAddr
     */
    public void setDepAddr(String depAddr) {
        this.depAddr = depAddr;
    }
    /**
     * Read the data of desAddr out of the database.
     *
     * @return Return the value of the desAddr
     */
    public String getDesAddr() {
        return desAddr;
    }
    /**
     * Write the new desAddr value to the database
     *
     * @param desAddr Value of the new desAddr
     */
    public void setDesAddr(String desAddr) {
        this.desAddr = desAddr;
    }
    /**
     * Read the data of totalTime out of the database.
     *
     * @return Return the value of the totalTime
     */
    public String getTotalTime() {
        return totalTime;
    }
    /**
     * Write the new totalTime value to the database
     *
     * @param totalTime New value of totalTime
     */
    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
    /**
     * Read the data of delayStatus out of the database.
     *
     * @return Return the value of the delayStatus
     */
    public String getDelayStatus() {
        return delayStatus;
    }
    /**
     * Write the new delayStatus value to the database
     *
     * @param delayStatus New value of delayStatus
     */
    public void setDelayStatus(String delayStatus) {
        this.delayStatus = delayStatus;
    }
    /**
     * Read the data of luggage out of the database.
     *
     * @return Return the value of the luggage
     */
    public String getLuggage() {
        return luggage;
    }
    /**
     * Write the new luggage value to the database
     *
     * @param luggage New value of luggage
     */
    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }
}