package com.example.javafxdemo.utils;

import com.example.javafxdemo.HelloApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassPath {
    public static String classPath = HelloApplication.class.getResource("").getPath();

}
