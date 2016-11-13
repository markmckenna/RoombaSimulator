package com.lantopia.roombasimulator;

/**
 * Manages a Roomba behavioural simulation, including a household floor plan with various kinds of obstacle, and a Roomba.
 *
 * The simulation is fundamentally geographical.  This object knows the size of environment, obstacles and Roomba.  It also
 * knows what the roomba can do, and that entities in the environment can move around.
 *
 * Clients may want simply to render a section of the scene; or they may want to use the state of the scene to derive
 * graphs or statistics.  Because of this variance this simulation should expose its value structure to clients, enabling
 * the maximum degree of inspection.
 *
 * The simulation should be time-independent, allowing at least forward, slow-mo, pause and reverse modes.  Ideally it would
 * also support arbitrary 'seeking' to a particular stage in the simulation, enabling a high degree of 'browsing' through the
 * simulation's behaviour.
 *
 * The main goal of the project is to allow for exploration of the Roomba's behaviour, so this behaviour should be provided by
 * other components.  Since different environments may often require different behaviour, having the environment be configurable
 * is also important.
 *
 * All dimensions and angles given throughout this module are interpreted as metres and degrees from 'up', respectively.  As the
 * Roomba doesn't have a global navigation system, which worldly direction 'up' is doesn't matter, so long as it is consistently
 * used throughout the scene.
 */
public final class Simulation {
    private final Environment environment;
    private final Roomba roomba;
    private final double roombaX;
    private final double roombaY;
    private final double roombaOrientation;

    private double time;

    public static Simulation create(Environment environment, Roomba roomba, double roombaX, double roombaY, double roombaOrientation) {
        return new Simulation(environment, roomba, roombaX, roombaY, roombaOrientation);
    }


    private Simulation(Environment environment, Roomba roomba, double roombaX, double roombaY, double roombaOrientation) {
        this.environment = environment;
        this.roomba = roomba;
        this.roombaX = roombaX;
        this.roombaY = roombaY;
        this.roombaOrientation = roombaOrientation;
    }


    /** Sets the current time in the simulation. Modifying this will have the effect of running the simulation for the difference
     * between the old time and the new time.
     */
    public double time(double seconds) { time = seconds; return time; }
    public double time() { return time; }


    /** Starts the roomba in this simulation.  This is equivalent to the user pressing the 'create' button twice while the Roomba
     * is asleep, or once while the roomba is awaiting instructions. */
    public void startRoomba() {
        // TODO: create the roomba
    }

    public double roombaOrientation() {
        return roombaOrientation;
    }
}
