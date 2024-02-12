package org.example.ej00;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public void init (){
        System.out.println("Iniciando la aplicación");
    }
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Creando el primer escenario o pantalla");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Hasta luego");
    }

    public static void main(String[] args) {
        launch();
    }
}