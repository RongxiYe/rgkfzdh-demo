package com.example.javafxdemo;


import com.example.javafxdemo.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImagePrintTest {
    @Test
    public void test() throws IOException {
        URL backgroundPath = HelloApplication.class.getResource("/com/example/javafxdemo/ticket.png");
        String message = "John";
        String outPutPath = "./user-ticket.png";

        Utils.overlapImage(backgroundPath, message, outPutPath,87,169,22);

        File file = new File("./user-ticket.png");
        Assert.assertTrue(file.exists());
    }



}
