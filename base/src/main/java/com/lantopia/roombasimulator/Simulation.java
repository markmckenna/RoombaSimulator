package com.lantopia.roombasimulator;

public final class Simulation {
    public interface DrawingDelegate {
        void drawRectangularObstacle(double x1, double y1, double x2, double y2);
        void drawRoomba(double x, double y, double radius);
    }

    public Simulation() {}

    public void renderSimulation(DrawingDelegate delegate) {
        delegate.drawRectangularObstacle(0, 0, 25, 50);
        delegate.drawRectangularObstacle(75, 50, 100, 100);
        delegate.drawRoomba(50, 50, 5);
    }
}
