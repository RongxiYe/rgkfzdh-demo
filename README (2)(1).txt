A Smart Flight Check-In Software
Authors: members of Software Engineering Team 60.

Introduction
This is a desktop software for self-service check-in developed by JavaFX. This software enables
passengers to check in, select seats, choose a meal plan and receive boarding passes. You can
also finetune it along with your requirement since it is designed to be every compatible. It can run
on Windows and Linux OS.

Technologies used
Java, JavaFX, JSON, XML(for FXML), Maven, Git.

Runtime requirements
jre 15.0

Usage
java -jar .jar

Diretory
src
├─main
│  ├─java
│  │  │  module-info.java
│  │  │  
│  │  └─com
│  │      └─example
│  │          └─javafxdemo /*Controller files for every page*/
│  │              │  Entry.java
│  │              │  HelloApplication.java
│  │              │  
│  │              ├─controller
│  │              │  │  Controller.java
│  │              │  │  Handler.java
│  │              │  │  MainController.java
│  │              │  │  
│  │              │  ├─FirstPage
│  │              │  │      FirstPageController.java
│  │              │  │      
│  │              │  ├─login
│  │              │  │      HelloController.java
│  │              │  │      InputIdController.java
│  │              │  │      ScanFileController.java
│  │              │  │      
│  │              │  └─user
│  │              │          CreditInfoController.java
│  │              │          FirstViewController.java
│  │              │          LastPageController.java
│  │              │          MealController.java
│  │              │          PrintPageController.java
│  │              │          SeatController.java
│  │              │          SmConfirmController.java
│  │              │          
│  │              ├─data
│  │              │      CurrentData.java
│  │              │      
│  │              ├─res
│  │              │      id.json
│  │              │      
│  │              ├─test
│  │              │      FirstOverviewTest.java
│  │              │      ImageTest.java
│  │              │      MealTest.java
│  │              │      SeatTest.java
│  │              │      
│  │              └─utils 
│  │                      ClassPath.java
│  │                      Page.java
│  │                      PrintProgress.java
│  │                      Tool.java
│  │                      UserData.java
│  │                      Utils.java
│  │                      
│  └─resources /*fxml files for every page and pictures used in printing part*/
│      └─com
│          └─example
│              └─javafxdemo
│                      boarding.png
│                      checkin-view.fxml
│                      credit-info.fxml
│                      Data.json /*Test database, including user name, password, flight information, etc.*/
│                      first-page.fxml
│                      first-view.fxml
│                      hello-view.fxml
│                      help-info.fxml
│                      input-id.fxml
│                      last-page.fxml
│                      main.fxml
│                      meal-select.fxml
│                      scan-id.fxml
│                      seat-select.fxml
│                      sm-confirm.fxml
│                      tag.png
│                      ticket.png
│                      
└─test
    └─java
        └─com
            └─example
                └─javafxdemo
                    └─test
                            ScanFileTest.java

Sketches