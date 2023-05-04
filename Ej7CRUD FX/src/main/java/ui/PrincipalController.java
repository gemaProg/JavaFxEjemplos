package ui;

import dao.DaoAnimales;
import domain.modelo.Animal;
import servicios.ServiciosAnimales;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    private ServiciosAnimales sa;
    private final MainViewModel viewModel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MFXButton botonAdd;

    @FXML
    private MFXButton botonDelete;

    @FXML
    private MFXButton botonUpdate;

    @FXML
    private TableView<Animal> tablaAnimales;

    @FXML
    private TableColumn<Animal, String> columna1;

    @FXML
    private TableColumn<Animal, Integer> columna2;

    @FXML
    private TableColumn<Animal, String> columna3;

    @FXML
    private TableColumn<Animal, String> columna4;

    @FXML
    private MFXComboBox<String> comboBox;

    @FXML
    private MFXTextField nombre;

    @FXML
    private MFXTextField edad;

    @FXML
    private MFXTextField id;

    @FXML
    private Label label;

    @FXML
    private MFXToggleButton toggleidioma;

    @FXML
    private MFXToggleButton modooscuro;

    public PrincipalController() {
        viewModel = new MainViewModel(new ServiciosAnimales(new DaoAnimales()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sa = new ServiciosAnimales(new DaoAnimales());
        tablaAnimales.setItems(viewModel.getAnimales());
        //mapeo de los atributos a las columnas
        columna1.setCellValueFactory(new PropertyValueFactory<>("id"));
        columna2.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna3.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columna4.setCellValueFactory(new PropertyValueFactory<>("raza"));
        comboBox.getItems().addAll(resourceBundle.getString("combo1"), resourceBundle.getString("combo2"), resourceBundle.getString("combo3"),resourceBundle.getString("combo4"));
    }

    @FXML
    private void cambioIdioma() {
        ResourceBundle bundle;
        if (toggleidioma.isSelected()) {
            bundle = ResourceBundle.getBundle("textosFX", Locale.ENGLISH);
        } else {
            bundle = ResourceBundle.getBundle("textosFX", Locale.getDefault());
        }
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/fxml/principal.fxml"), bundle);

        label.setText(bundle.getString("titulo"));
        columna1.setText(bundle.getString("columnaId"));
        columna2.setText(bundle.getString("columnaNombre"));
        columna3.setText(bundle.getString("columnaEdad"));
        columna4.setText(bundle.getString("columnaRaza"));
        botonAdd.setText(bundle.getString("botonAdd"));
        botonDelete.setText(bundle.getString("botonDelete"));
        botonUpdate.setText(bundle.getString("botonUpdate"));
        nombre.setPromptText(bundle.getString("columnaNombre"));
        edad.setPromptText(bundle.getString("columnaEdad"));
        id.setPromptText(bundle.getString("columnaId"));
        comboBox.setPromptText(bundle.getString("columnaRaza"));
        toggleidioma.setText(bundle.getString("idioma"));
        modooscuro.setText(bundle.getString("modooscuro"));
        comboBox.getItems().clear();
        comboBox.getItems().addAll(bundle.getString("combo1"), bundle.getString("combo2"), bundle.getString("combo3"),bundle.getString("combo4"));
    }

    @FXML
    private void modoOscuro() {
        if (modooscuro.isSelected()) {
            toggleidioma.setTextFill(Color.WHITE);
            modooscuro.setTextFill(Color.WHITE);
            anchorPane.setStyle("-fx-background-color: #000000;");
            label.setTextFill(Color.WHITE);
            label.setStyle("-fx-background-color: #000000");
            botonAdd.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
            botonDelete.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
            botonUpdate.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
        } else {
            toggleidioma.setTextFill(Color.BLACK);
            modooscuro.setTextFill(Color.BLACK);
            anchorPane.setStyle("-fx-background-color: #ffffff;");
            label.setTextFill(Color.BLACK);
            label.setStyle("-fx-background-color: #ffffff");
            botonAdd.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            botonDelete.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            botonUpdate.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
        }
    }

    @FXML
    private void addAnimal() {
        if (id.getText().isEmpty() || nombre.getText().isEmpty() || edad.getText().isEmpty() || comboBox.getValue().isEmpty()) {
            alertaErrorAddAnimal();
        } else {
            Animal p = new Animal(id.getText(), nombre.getText(), Integer.parseInt(edad.getText()), comboBox.getValue());
            if (sa.addAnimal(p)) {
                tablaAnimales.getItems().add(p);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Animal añadido correctamente");
                alert.setHeaderText("Animal añadido correctamente");
                alert.setContentText("Se ha añadido correctamente");
                alert.show();
            } else {
                alertaErrorAddAnimal();
            }
        }
    }

    @FXML
    private void deleteAnimal() {
        if (nombre.getText().isEmpty() || edad.getText().isEmpty() || id.getText().isEmpty() || comboBox.getValue().isEmpty()) {
            alertaErrorDeleteAnimal();
        } else {
            Animal p = new Animal(id.getText(),nombre.getText(), Integer.parseInt(edad.getText()), comboBox.getValue());
            if (sa.deleteAnimal(p)) {
                tablaAnimales.getItems().remove(new Animal(id.getText(),nombre.getText(), Integer.parseInt(edad.getText()), comboBox.getValue()));
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Animal eliminada con éxito");
                alert.setHeaderText("Animal eliminada con éxito");
                alert.setContentText("Se ha eliminado correctamente");
                alert.show();
            } else {
                alertaErrorDeleteAnimal();
            }
        }
    }

    @FXML
    private void updateAnimal() {
        if (nombre.getText() == null || edad.getText() == null || id.getText() == null || comboBox.getValue() == null) {
            alertaErrorUpdateAnimal();
        } else {
            Animal animal1 = new Animal(id.getText(),nombre.getText(), Integer.parseInt(edad.getText()), comboBox.getValue());
            Animal animal2 = tablaAnimales.getSelectionModel().getSelectedItem();
            if (sa.updateAnimal(animal1, animal2)) {
                tablaAnimales.getItems().remove(animal2);
                tablaAnimales.getItems().add(animal1);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Animal actualizado con éxito");
                alert.setHeaderText("Animal actualizado con éxito");
                alert.setContentText("Se ha actualizado correctamente");
                alert.show();
            } else {
                alertaErrorUpdateAnimal();
            }
        }
    }

    @FXML
    private void ayuda() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Ayuda");
        a.setHeaderText("Ayuda");
        a.setContentText("Selecciona el animal a actualizar en la tabla e introduce los nuevos datos");
        a.show();
    }

    @FXML
    private void alertaErrorAddAnimal() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al añadir el animal");
        alert.setContentText("No se ha podido añadir el animal");
        alert.show();
    }

    @FXML
    private void alertaErrorUpdateAnimal() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al actualizar animal");
        alert.setContentText("Problemas al actualizar el animal");
        alert.show();
    }
    @FXML
    private void alertaErrorDeleteAnimal() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al eliminar el animal");
        alert.setContentText("No se ha podido eliminar el animal");
        alert.show();
    }

}