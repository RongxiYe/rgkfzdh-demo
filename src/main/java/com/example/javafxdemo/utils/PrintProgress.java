package com.example.javafxdemo.utils;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrintProgress {
    public static ProgressBar pb = new ProgressBar(0);
    public static VBox vBox = new VBox();
    public static Button btn1 = new Button("OK, I have taken all my materials.");
    public static Stage stage = new Stage();
    public static Label label = new Label();
    public static Scene scene = new Scene(vBox,400,300);
    static {
        stage.initModality(Modality.APPLICATION_MODAL);
        label.setText("Do not leave before all materials have been printed!");
        btn1.setOnMouseClicked(event -> {
            System.out.println("ok");
            stage.close();
        });
        vBox.getChildren().addAll(label,pb);
        vBox.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.setTitle("Printing...");
    }
    public static void show() {
        stage.show();
    }
    public static void finish(){
        pb.setProgress(1);
        vBox.getChildren().add(btn1);
    }

    public static void half(){
        pb.setProgress(0.5);
    }
}
