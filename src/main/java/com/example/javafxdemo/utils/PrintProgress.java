package com.example.javafxdemo.utils;

import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.example.javafxdemo.utils.PrintProgress.runTask;

public class PrintProgress {
    public static ProgressBar pb = new ProgressBar(0);
    public static VBox vBox = new VBox(20);
    public static Button btn1 = new Button("OK, I have taken all my materials.");
    public static Stage stage = new Stage();
    public static Label label = new Label();
    public static Scene scene = new Scene(vBox,400,300);
    public static Alert alert;
    static {
        stage.initModality(Modality.APPLICATION_MODAL);
        label.setText("Do not leave before all materials have been printed!");
        pb.setPrefWidth(200);
        pb.setPrefHeight(30);
        btn1.setOnMouseClicked(event -> {
            System.out.println("ok");
            stage.close();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Thanks!");
            alert.setContentText("Thank you for using smart check-in system!");
            alert.showAndWait();
            CurrentData.userData = null;
            MainController main = (MainController) Handler.getController(Page.MAIN);
            main.loadRoot(Page.LASTPAGE);
        });
        vBox.getChildren().addAll(label,pb,btn1);
        btn1.setVisible(false);
        vBox.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.setTitle("Printing...");
    }
    public static void show() {
        stage.show();
    }




    public static boolean printInfo(){
        //收集userdata中所需的信息，并生成一个图片文件
        //将图片文件显示在屏幕上（机票）
        runTask(new MyTask());
        return true;
    }

    public static void runTask(Task task) {
        pb.setVisible(true);
        pb.setDisable(false);
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                return task;
            }
        };
        pb.progressProperty().bind(task.progressProperty());
        task.messageProperty().addListener((observable, oldValue, newValue) -> {
            label.setText(service.getMessage());
        });
        task.valueProperty().addListener((observable, oldValue, newValue) -> {
            label.setTextFill(Color.GRAY);
            if ((int)newValue == 100 || (int)newValue == 1){
                label.setTextFill(Color.GREEN);
                taskComplete();
            }
            if ((int) newValue == -1){
                label.setTextFill(Color.RED);
                taskOnError();
            }
        });
        service.restart();
    }

    /**
     *
     */
    public static void taskOnError() {

    }
    public static void taskComplete() {
        pb.setDisable(true);
        btn1.setVisible(true);
    }
    private static class MyTask extends Task {
        @Override
        protected Object call() throws Exception {

            updateMessage("Printing...");
            updateValue(0);
            Thread.sleep(2000);
            try {
                //这里使用while循环表示执行的任务，每循环一次更新一次label
                int i = 0;
                while (i < 3) {
                    updateProgress(30*i, 100);
                    updateMessage("Printing...  " + i + "% ");
                    updateValue(i*30);
                    if(i==1){
                        UserData userData = CurrentData.userData;
                        //print boarding pass
                        String sn = userData.getSurname();
                        String fn = userData.getFirstname();
                        String an = userData.getFlightNum();
                        String date = userData.getFlyingDate();
                        String stn = userData.getSeatNum();
                        String ml = userData.getMeal();


                        //print carry-on tag
                        //print check in baggage ticket
                        String co = userData.getCarryOn();
                        String ba = userData.getLuggage();


                    }
                    Thread.sleep(50);
                    i++;
                }
                updateProgress(100,100);
                updateValue(100);
                updateMessage("Printing succeed！");
                return 1;
            } catch (Exception e) {
                updateMessage("Printing Error！");
                updateValue(-1);
                updateProgress(-1, 1);
                return -1;
            }
        }
    }
}
