package com.lantopia.roombasimulator.desktop;

import com.lantopia.roombasimulator.Environment;
import com.lantopia.roombasimulator.Renderer;
import com.lantopia.roombasimulator.Roomba;
import com.lantopia.roombasimulator.Simulation;
import com.lantopia.roombasimulator.controllers.SimpleControllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public final class RoombaSimulator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // set up the simulation (TODO separate this out)

        final Environment environment = Environment.create()
                .wallAt(0,0,   90.0,  3) // 3x3 metre room
                .wallAt(0,0,   180.0, 3)
                .wallAt(3,3, 0.0,   3)
                .wallAt(3,3, 270.0, 3)
                .dockAt(0.05, 1.5, 90.0); // dock in middle of lefthand wall, 5cm out, facing right

        final Roomba roomba = Roomba.create(SimpleControllers.simpleRicochetController());

        final Simulation simulation = Simulation.create(environment, roomba, 0.05, 1.5, 90.0); // roomba starts on dock


        // set up the visual renderer

        final Canvas canvas = new Canvas(600, 600);
        final StackPane root = new StackPane(canvas);

        final JavaFXRenderer renderer = new JavaFXRenderer(new Renderer());

        final Scene scene = new Scene(root, 600, 600, Color.BLACK);

        canvas.setScaleX(scene.getWidth()/canvas.getWidth());
        canvas.setScaleY(scene.getHeight()/canvas.getHeight());

        primaryStage.setTitle("Roomba Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();


        // leftWheelSpeed the simulation advancing

        simulation.time(1.0);

        renderer.draw(canvas);
    }

    public static void main(String... args) {
        launch(args);
    }
}
