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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

import static com.example.javafxdemo.utils.PrintProgress.runTask;

public class PrintProgress {
    public static ProgressBar pb = new ProgressBar(0);
    public static VBox vBox = new VBox(20);
    public static VBox vBox2 = new VBox(10);
    public static HBox hBox = new HBox(10);
    public static Button btn1 = new Button("OK, I have taken all my materials.");
    public static Stage stage = new Stage();
    public static Label label = new Label();
    public static Scene scene = new Scene(vBox,1200,800);
    public static ImageView board = new ImageView();
    public static ImageView tag = new ImageView();
    public static ImageView ticket = new ImageView();
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
        vBox2.getChildren().addAll(board,tag);
        hBox.getChildren().addAll(vBox2,ticket);
        vBox.getChildren().addAll(label,pb,btn1,hBox);
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
                updateProgress(30, 100);
                updateMessage("Printing...  " + 30 + "% ");
                updateValue(30);
                        UserData userData = CurrentData.userData;
                        //print boarding pass
                        String[] str0 = new String[9];
                        str0[0] = userData.getFirstname()+" "+userData.getSurname();
                        str0[1] = userData.getSeatNum();
                        str0[2] = userData.getMeal();
                        str0[3] = userData.getFlyingDate();
                        str0[4] = "";
                        str0[5] = userData.getFlightNum();
                        str0[6] = userData.getDepAddr();
                        str0[7] = userData.getDesAddr();
                        if(userData.getSeatNum().charAt(1)=='1'){
                            str0[8] = "FIRST CLASS";
                        }else{
                            str0[8] = "ECONOMY";
                        }
                        Utils.printBoarding(str0);
                updateProgress(60, 100);
                updateMessage("Printing...  " + 60 + "% ");
                updateValue(60);
                Image img1 = new Image(new File(ClassPath.classPath+"user-boarding.png").toURI().toString());
                board.setImage(img1);
                board.setVisible(true);

                //print carry-on tag
                    if (userData.getCarryOn().equalsIgnoreCase("true")) {
                        String[] str1 = new String[3];
                        str1[0] = userData.getFirstname() + " " + userData.getSurname();
                        str1[1] = userData.getDepAddr();
                        str1[2] = userData.getDesAddr();
                        Utils.printTag(str1);
                        Image img2 = new Image(new File(ClassPath.classPath+"user-tag.png").toURI().toString());
                        tag.setImage(img2);
                        tag.setVisible(true);
                    }

                updateProgress(90, 100);
                updateMessage("Printing...  " + 90 + "% ");
                updateValue(90);
                    //print check in baggage ticket
                    if (!userData.getLuggage().equalsIgnoreCase("None")) {
                        String[] str2 = new String[4];
                        str2[0] = userData.getFirstname() + " " + userData.getSurname();
                        str2[1] = userData.getDepAddr();
                        str2[2] = userData.getDesAddr();
                        str2[3] = userData.getFlightNum();
                        Utils.printTicket(str2);
                        Image img3 = new Image(new File(ClassPath.classPath+"user-ticket.png").toURI().toString());
                        ticket.setImage(img3);
                        ticket.setVisible(true);
                    }

                updateProgress(100,100);
                updateValue(100);
                updateMessage("Printing succeed！");

                return 1;
            } catch (Exception e) {
                updateMessage("Printing Error！");
                e.printStackTrace();
                updateValue(-1);
                updateProgress(-1, 1);
                return -1;
            }
        }
    }
}
