module org.example.ej00 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ej00 to javafx.fxml;
    exports org.example.ej00;
}