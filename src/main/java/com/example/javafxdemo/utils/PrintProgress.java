package com.example.javafxdemo.utils;

import com.example.javafxdemo.HelloApplication;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.data.CurrentData;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

import static com.example.javafxdemo.utils.PrintProgress.runTask;

/**
 * PrintProgress is used to control how the flight information print page is loaded
 * and how the information is presented.
 *
 * @author RongxiYe
 * @version 1.0
 */
public class PrintProgress {
    /**
     * pb is used to show loading progress
     */
    public static ProgressBar pb = new ProgressBar(0);
    /**
     * vBox is used to divide the page vertically into 3 sections
     * so that content can be inserted in that area.
     */
    public static VBox vBox = new VBox(20);
    /**
     * vBox2 is used to divide the bottom section which is divided by vBox into 2 sections vertically
     */
    public static VBox vBox2 = new VBox(10);
    /**
     * hBox is used to divide the page horizontally into 2 sections
     */
    public static HBox hBox = new HBox(10);
    /**
     * btn1 is a button that can be clicked on to confirm when the user has taken all the materials
     */
    public static Button btn1 = new Button("OK, I have taken all my materials.");
    /**
     * stage is a stage on this page
     */
    public static Stage stage = new Stage();
    /**
     * label is a label on this page
     */
    public static Label label = new Label();
    /**
     * scene is used to specify the length and width of the vBox
     */
    public static Scene scene = new Scene(vBox,1200,800);
    /**
     * board is a picture and some information will be print on it
     */
    public static ImageView board = new ImageView();
    /**
     * tag is a picture and some information will be print on it
     */
    public static ImageView tag = new ImageView();
    /**
     * ticket a picture and some information will be print on it
     */
    public static ImageView ticket = new ImageView();
    /**
     * alert is a pop-up window which will pop up when the user has completed the print operation
     */
    public static Alert alert;

    /**
     * Initialisation of the sections
     */
    static {
        stage.initModality(Modality.APPLICATION_MODAL);
        label.setText("Do not leave before all materials have been printed!");
        pb.setPrefWidth(200);
        pb.setPrefHeight(30);
        btn1.setStyle("-fx-min-height: 30; -fx-min-width: 80; -fx-background-color: linear-gradient(#47b0a5 0,#4dbd92 48%,#53c67d 100%);-fx-text-fill: #ffff");
        btn1.setFont(new Font("Bookman Old Style Bold Italic",17));
        btn1.setOnMouseClicked(event -> {
            System.out.println("ok");
            stage.close();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thanks!");
            alert.setHeaderText("Thanks!");
            alert.setContentText("Thank you for using smart check-in system!");
            ButtonType buttonModify = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonModify);
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

    /**
     * The page starts loading and displays
     */
    public static void show() {
        stage.show();
    }

    /**
     * Start printing
     * Start calling and running the runTask() method
     *
     * @return {@code true} if the runTask() method succeeds
     */
    public static boolean printInfo(){
        runTask(new MyTask());
        return true;
    }

    /**
     * The runTask() method is used to combine the MyTask() method with the progress bar
     * The progress bar will turn green when the load is successful
     * When the load fails, the progress bar turns red
     *
     * @param task integer which is used to pass parameters
     */
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
     * Task is running with an error
     */
    public static void taskOnError() {

    }

    /**
     * Task successfully completed
     */
    public static void taskComplete() {
        pb.setDisable(true);
        btn1.setVisible(true);
    }

    /**
     * MyTask() is used to control the specific task details
     * Extends the Task class.
     * Override the call() method.
     * Combine the specific degree of page loading with the progress bar.
     * Reach the point where the progress bar can show the loading percentage.
     *
     */
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
                Image img1 = new Image(new File("./user-boarding.png").toURI().toString());
                board.setImage(img1);
                board.setVisible(true);

                //print carry-on tag
                    if (userData.getCarryOn().equalsIgnoreCase("true")) {
                        String[] str1 = new String[3];
                        str1[0] = userData.getFirstname() + " " + userData.getSurname();
                        str1[1] = userData.getDepAddr();
                        str1[2] = userData.getDesAddr();
                        Utils.printTag(str1);
                        Image img2 = new Image(new File("./user-tag.png").toURI().toString());
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
                        Image img3 = new Image(new File("./user-ticket.png").toURI().toString());
                        ticket.setImage(img3);
                        ticket.setVisible(true);
                    }

                updateProgress(100,100);
                updateValue(100);
                updateMessage("Printing succeed! ");
                return 1;
            } catch (Exception e) {
                updateMessage("Printing Error! ");
                e.printStackTrace();
                updateValue(-1);
                updateProgress(-1, 1);
                return -1;
            }
        }
    }
}
