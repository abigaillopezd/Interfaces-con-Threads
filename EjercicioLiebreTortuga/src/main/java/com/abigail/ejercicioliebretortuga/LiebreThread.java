package com.abigail.ejercicioliebretortuga;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class LiebreThread extends Thread {

    private final ProgressBar progressBar;
    private final Label label;
    private final Button btnIniciar;

    public LiebreThread(ProgressBar progressBar, Label label, Button btnIniciar) {
        this.progressBar = progressBar;
        this.label = label;
        this.btnIniciar = btnIniciar;
        setDaemon(true);
    }

    @Override
    public void run() {
        int pasos = 100;

        for (int i = 1; i <= pasos; i++) {
            if (i == 40) {
                Platform.runLater(() -> label.setText("La Liebre: ¡Se durmió!"));

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> label.setText("La Liebre: ¡Despertó y está corriendo!"));
            }

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double progreso = (double) i / pasos;

            Platform.runLater(() -> progressBar.setProgress(progreso));
        }

        Platform.runLater(() -> btnIniciar.setDisable(false));
    }
}