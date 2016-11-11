package com.lantopia.roombasimulator.desktop;

import com.lantopia.roombasimulator.Simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class RoombaSimulator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Canvas canvas = new Canvas(600, 600);
        final StackPane root = new StackPane(canvas);

        final Simulation simulation = new Simulation();

        // The simulation should have one roomba and a floor plan which defines some regions.
        // We will also need to control the simulation.
        final JavaFXRenderer renderer = new JavaFXRenderer(simulation);

        final Scene scene = new Scene(root, 600, 600, Color.BLACK);

        canvas.setScaleX(scene.getWidth()/canvas.getWidth());
        canvas.setScaleY(scene.getHeight()/canvas.getHeight());

        renderer.draw(canvas);

        primaryStage.setTitle("Roomba Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}
