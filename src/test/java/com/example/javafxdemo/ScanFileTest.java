package com.example.javafxdemo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ScanFileTest {
    @Test
    void test() throws IOException {
        Stage stage = new Stage();
        FXMLLoader uploadLoader = new FXMLLoader(HelloApplication.class.getResource("scan-id.fxml"));
        uploadLoader.load();
        Scene scene = new Scene(uploadLoader.getRoot(), 900, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
