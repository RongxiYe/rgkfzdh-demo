package com.example.javafxdemo.test;

import com.example.javafxdemo.utils.ClassPath;
import com.example.javafxdemo.utils.Utils;

import java.io.IOException;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        String backgroundPath = ClassPath.classPath+ "boarding.png";
        String message = "John";
        String outPutPath = ClassPath.classPath+ "user-boarding.png";

        Utils.overlapImage(backgroundPath, message, outPutPath,45,126);
        Utils.overlapImage(outPutPath, message, outPutPath,45,126);

    }
}
