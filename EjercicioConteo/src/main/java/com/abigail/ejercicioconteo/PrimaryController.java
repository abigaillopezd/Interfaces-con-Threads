package com.abigail.ejercicioconteo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtClicks;

    @FXML
    private Button btnContar;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button btnEsperar;

    private int contadorClics = 0;

   
    @FXML
    private void handleBtnContar() {
        contadorClics++;
        txtClicks.setText(String.valueOf(contadorClics));
    }

   
    @FXML
    private void handleBtnEsperar() {
        
        btnEsperar.setDisable(true);
        progressBar.setProgress(0.0);

        Thread hiloEspera = new Thread(() -> {
            int tiempoTotalMs = 10000; 
            int pasos = 100;
            long tiempoPaso = tiempoTotalMs / pasos;

            for (int i = 1; i <= pasos; i++) {
                try {
                    Thread.sleep(tiempoPaso);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double progresoActual = (double) i / pasos;

                Platform.runLater(() -> {
                    progressBar.setProgress(progresoActual);
                });
            }

            Platform.runLater(() -> {
                btnEsperar.setDisable(false);
            });
        });

        hiloEspera.setDaemon(true);
        hiloEspera.start();
    }
}