package com.example.javafxdemo.controller;

import com.example.javafxdemo.data.UserData;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public abstract class Controller {
    private FXMLLoader[] loaders;
    private UserData userData;

    public abstract void init(UserData data, FXMLLoader[] loaders) throws IOException;
}
