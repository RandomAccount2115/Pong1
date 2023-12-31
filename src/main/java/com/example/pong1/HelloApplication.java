package com.example.pong1;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double MARGIN = 50;
    private static final double ARENAWIDTH = WIDTH - 2*MARGIN;
    private static final double ARENAHEIGHT = HEIGHT - 2*MARGIN;
    private static final double ARENAX1 = MARGIN;
    private static final double ARENAY1 = MARGIN;
    private static final double ARENAX2 = ARENAX1 + ARENAWIDTH;
    private static final double ARENAY2 = ARENAY1 + ARENAHEIGHT;

    private static final int LICZBAKULEK = 10;
    private Kulka[] kulki = new Kulka[LICZBAKULEK];

    private static final double R = 10;

    private double[] x = new double[LICZBAKULEK];
    private double[] y = new double[LICZBAKULEK];

    private double[] vx = new double[LICZBAKULEK];
    private double[] vy = new double[LICZBAKULEK];

    @Override
    public void start(Stage stage) throws IOException {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        stage.setTitle("Kulki");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();

        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);

        this.initKula();

        t.play();
    }

    public static void main(String[] args) {
        launch();
    }

    private void run(GraphicsContext gc){

        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1, ARENAY1, ARENAWIDTH, ARENAHEIGHT);

        for(int i = 0; i < LICZBAKULEK; i++) {

            kulki[i].checkBoundaryCollision(ARENAX1, ARENAY1, ARENAX2, ARENAY2);
            kulki[i].update();
            kulki[i].draw(gc);

        }

    }

    private void initKula(){

        Random lott = new Random();

        for(int i = 0; i < LICZBAKULEK/2; i++){

            kulki[i] = new Rugby(
                x[i] = lott.nextDouble()*ARENAWIDTH+ARENAX1,
                y[i] = lott.nextDouble()*ARENAHEIGHT+ARENAY1,
                vx[i] = 5+lott.nextDouble()*20,
                vy[i] = 5+lott.nextDouble()*20,
                    10,
                    10,
                    15
            );

            for(int z = LICZBAKULEK/2; z < LICZBAKULEK; z++){

                kulki[z] = new Kulka(
                        x[i] = lott.nextDouble()*ARENAWIDTH+ARENAX1,
                        y[i] = lott.nextDouble()*ARENAHEIGHT+ARENAY1,
                        vx[i] = 5+lott.nextDouble()*20,
                        vy[i] = 5+lott.nextDouble()*20,
                        10
                );

            }
        }



    }
}