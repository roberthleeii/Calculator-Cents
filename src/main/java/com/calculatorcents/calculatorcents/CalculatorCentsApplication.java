package com.calculatorcents.calculatorcents;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorCentsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorCentsApplication.class.getResource("Basic-Calculator-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculator Cents");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}