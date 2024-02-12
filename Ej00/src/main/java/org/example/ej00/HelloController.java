package org.example.ej00;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button boton;
    private int contador;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boton.setText("Hello World");
        /*boton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                contador++;
                System.out.println("he pinchado con el ratón"+ contador+ "veces");
            }
        });*/
        /*boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(actionEvent);
                contador++;
                System.out.println("he pinchado con el ratón"+ contador+ "veces");
            }
        });*/
    }

    @FXML
    protected void onHelloButtonClick() {
        contador++;
        if (contador==1) {
            welcomeText.setText("Welcome to JavaFX Application!");
            boton.setText("Adios");
        }else
            Platform.exit();
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getCode().getChar());
        if (keyEvent.getCode().getChar().equals("A"))
            System.out.println("Has introducido la letra A. Pincha el botón");
        else
            System.out.println("No pulses una tecla distinta de la A, pincha el botón");
    }
}