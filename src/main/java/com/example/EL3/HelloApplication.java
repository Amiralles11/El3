package com.example.EL3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final Logger log = LogManager.getLogger(HelloApplication.class);
    @Override
    public void start(Stage stage) throws IOException {
        log.info("\nInicio de la aplicación");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VentanaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ventana principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}