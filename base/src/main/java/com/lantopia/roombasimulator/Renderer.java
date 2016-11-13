package com.lantopia.roombasimulator;

/**
 * Abstractly defines the render process for a simulation.  Downstream renderers (such as the desktop display
 * engine) use this to acquire platform-independent rendering logic.
 */
public final class Renderer {
    /**
     * Defines a set of methods that a renderer should implement to trigger drawing of entities.
     * These methods will be called using an arbitrary visual scale based on a virtual canvas
     * size of (100, 100).  The renderer, if it wants to control this, should appropriately transform
     * these values so the rendering takes place at a valid scale.
     */
    public interface Delegate {
        void drawRectangularObstacle(double x1, double y1, double x2, double y2);
        void drawRoomba(double x, double y, double radius);
    }

    /**
     * Invoke this method to refresh the rendering.
     * @param delegate
     */
    public void update(Delegate delegate) {
        delegate.drawRectangularObstacle(0, 0, 25, 50);
        delegate.drawRectangularObstacle(75, 50, 100, 100);
        delegate.drawRoomba(50, 50, 5);
    }
}
