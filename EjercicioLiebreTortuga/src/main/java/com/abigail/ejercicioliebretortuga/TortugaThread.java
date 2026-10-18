package com.abigail.ejercicioliebretortuga;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.application.Platform;
public class TortugaThread extends Thread {

    private final ProgressBar progressBar;
    private final Label label;

    public TortugaThread(ProgressBar progressBar, Label label) {
        this.progressBar = progressBar;
        this.label = label;
        setDaemon(true);
    }

    @Override
    public void run() {
        int pasos = 100;
        for (int i = 1; i <= pasos; i++) {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double progreso = (double) i / pasos;

            Platform.runLater(() -> progressBar.setProgress(progreso));
        }

        Platform.runLater(() -> label.setText("La Tortuga: ¡Llegó a la meta!"));
    }
}