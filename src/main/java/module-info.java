module com.example.proyecto_semestral {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto_semestral to javafx.fxml;
    exports com.example.proyecto_semestral;
}