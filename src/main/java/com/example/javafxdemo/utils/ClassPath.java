package com.example.javafxdemo.utils;

import com.example.javafxdemo.HelloApplication;

public class ClassPath {
    public static String classPath = HelloApplication.class.getResource("").getPath();
}
