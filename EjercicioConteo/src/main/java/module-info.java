module com.abigail.ejercicioconteo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.abigail.ejercicioconteo to javafx.fxml;
    exports com.abigail.ejercicioconteo;
}
