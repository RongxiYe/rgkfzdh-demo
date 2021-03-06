/**
 * all module information
 */
module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.desktop;
    requires gson;

    opens com.example.javafxdemo to javafx.fxml, javafx.graphics;
    exports com.example.javafxdemo;
    exports com.example.javafxdemo.controller.FirstPage;
    opens com.example.javafxdemo.controller.FirstPage to javafx.fxml;
    exports com.example.javafxdemo.controller.login;
    opens com.example.javafxdemo.controller.login to javafx.fxml;
    exports com.example.javafxdemo.controller.user;
    opens com.example.javafxdemo.controller.user to javafx.fxml;
    opens com.example.javafxdemo.controller to javafx.fxml;
    exports com.example.javafxdemo.controller;

    exports com.example.javafxdemo.data;

    opens com.example.javafxdemo.data to gson;
    exports com.example.javafxdemo.utils;
    opens com.example.javafxdemo.utils to gson;
}