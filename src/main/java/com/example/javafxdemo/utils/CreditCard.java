package com.example.javafxdemo.utils;

/**
 * CreditCard is an entity class for credit card information.
 *
 * @author RongxiYe
 * @version 1.0
 */
public class CreditCard {
    /**
     * First name <space> last name of a user.
     */
    private String name;
    /**
     * card number of a credit card
     */
    private String cardNo;
    /**
     * password of a credit card
     */
    private String cardPass;

    /**
     * get the name of the user.
     *
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of the user
     *
     * @param name name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the card number of the user.
     *
     * @return card number of the user
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * set the card number of the user.
     *
     * @param cardNo card number of the user
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * get the password of the user's card.
     *
     * @return password of the user's card
     */
    public String getCardPass() {
        return cardPass;
    }

    /**
     * get the name of the user.
     *
     * @param cardPass password of the user's credit card
     */
    public void setCardPass(String cardPass) {
        this.cardPass = cardPass;
    }
}
