package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@Log4j2
public class MainFX extends Application {
    //private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //logger.info("Hay dos opciones: anotación o con este atributo estático que carga el logger");
        log.info("La anotación simplifica esta tarea");
        log.debug("Mensaje de nivel de depuración");
        log.info("Mensaje de nivel de información");
        log.error("Mensaje de nivel de error");
        ResourceBundle rb = ResourceBundle.getBundle("textosFX", Locale.getDefault());
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/fxml/principal.fxml"),rb);
        AnchorPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle(rb.getString("title"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);
    }
}