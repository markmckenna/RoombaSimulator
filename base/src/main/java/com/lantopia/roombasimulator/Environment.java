package com.lantopia.roombasimulator;

/**
 * The simulation environment is essentially a collection of different kinds of entities, including dock, walls, people
 * and so on.  The environment knows the size and shape of each of these entities, and it locates them in 2D space.  The location
 * of these entities can change arbitrarily, to simulate things like people walking through the area, the Roomba itself moving
 * around, and people (or the Roomba) moving furniture or doors.
 *
 * The environment is treated as a mutable store of generic entities.  It is passive; entities are expected to operate on it,
 * but not be operated on by the environment.  It mainly just answers queries about the location of various kinds of geometry.
 */
public final class Environment {
    public static Environment create() { return new Environment(); }

    private Environment() {}


    public Environment wallAt(double x1, double y1, double orientation, double length) {
        // TODO: add a wall
        return this;
    }

    public Environment dockAt(double x1, double y1, double orientation) {
        // TODO: add a dock
        return this;
    }
}
