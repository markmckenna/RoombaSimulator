package com.lantopia.roombasimulator.desktop;

import com.lantopia.roombasimulator.Renderer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class JavaFXRenderer {
    private final Renderer renderer;

    JavaFXRenderer(Renderer renderer) {
        this.renderer = renderer;
    }


    void draw(Canvas canvas) {
        final GraphicsContext out = canvas.getGraphicsContext2D();

        renderer.update(new Renderer.Delegate() {
            @Override
            public void drawRectangularObstacle(double x1, double y1, double x2, double y2) {
                out.setStroke(Color.BLUE);
                out.setFill(Color.WHITE);
                out.fillRect(x1, y1, x2, y2);
            }

            @Override
            public void drawRoomba(double x, double y, double radius) {
                out.setStroke(Color.RED);
                out.strokeOval(x, y, radius, radius);
            }
        });
    }
}
