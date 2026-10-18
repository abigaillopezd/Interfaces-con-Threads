package com.abigail.ejercicioliebretortuga;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML
    private Button btnIniciar;

    @FXML
    private Label lblLiebre;

    @FXML
    private ProgressBar progressLiebre;

    @FXML
    private Label lblTortuga;

    @FXML
    private ProgressBar progressTortuga;

    @FXML
    private void handleBtnIniciar() {
        btnIniciar.setDisable(true);

        progressLiebre.setProgress(0.0);
        progressTortuga.setProgress(0.0);
        lblLiebre.setText("La Liebre: ¡Corriendo!");
        lblTortuga.setText("La Tortuga: ¡Está corriendo!");

        TortugaThread tortugaThread = new TortugaThread(progressTortuga, lblTortuga);
        LiebreThread liebreThread = new LiebreThread(progressLiebre, lblLiebre, btnIniciar);

        tortugaThread.start();
        liebreThread.start();
    }
}