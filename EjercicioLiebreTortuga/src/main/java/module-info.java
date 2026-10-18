module com.abigail.ejercicioliebretortuga {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.abigail.ejercicioliebretortuga to javafx.fxml;
    exports com.abigail.ejercicioliebretortuga;
}
