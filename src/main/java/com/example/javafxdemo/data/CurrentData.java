package com.example.javafxdemo.data;

import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;

/**
 * CurrentData includes current user and page information
 *
 * @author RongxiYe
 * @version 1.0
 */
public class CurrentData {

    /**
     * instance variable of current user information
     */
    public static UserData userData;
    /**
     * instance variable of current page information
     */
    public static Page currentPage;
    static{
        userData = new UserData();
        currentPage = null;
    }
}