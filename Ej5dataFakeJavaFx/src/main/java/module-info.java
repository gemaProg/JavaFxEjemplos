module com.example.dataFakerGenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires datafaker;

    opens com.example.dataFakerGenerator to javafx.fxml;
    exports com.example.dataFakerGenerator;
}