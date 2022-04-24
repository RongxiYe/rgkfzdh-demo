package com.example.javafxdemo.data;

import com.example.javafxdemo.utils.Page;
import com.example.javafxdemo.utils.UserData;

public class CurrentData {
    public static UserData userData;
    public static Page currentPage;
    static{
        userData = new UserData();
        currentPage = null;
    }
}