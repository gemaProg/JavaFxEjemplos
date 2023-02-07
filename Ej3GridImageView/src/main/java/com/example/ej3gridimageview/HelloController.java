package com.example.ej3gridimageview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private GridPane mainGrid;

    @FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome to JavaFX Application!");
    }

    public void click(MouseEvent mouseEvent) {
        int columna = 0;
        int fila = 0;
        /*for (Node node : mainGrid.getChildren()) {
            if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
                columna = GridPane.getColumnIndex(node);
                fila = GridPane.getRowIndex(node);
            }
        }
        System.out.println(fila+" "+columna);*/
        //Otra forma
        Node node = (Node) mouseEvent.getTarget();
        if (node != null && node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
            columna = GridPane.getColumnIndex(node);
            fila = GridPane.getRowIndex(node);
            System.out.println("Row : " + fila + ", Col : " + columna);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane pane;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #684714;");
                } else {
                    pane.setStyle("-fx-background-color: #ffe68e");
                }
                if (i == j) {
                    //addAll vs add
                    pane.getChildren().addAll(new ImageView(new Image("File:src/main/resources/com/example/ej3gridimageview/imagenes/CaballoNegro.png")));
                }
                mainGrid.add(pane, j, i);
            }
        }
    }

    public void enroque(ActionEvent actionEvent) {
    }
}