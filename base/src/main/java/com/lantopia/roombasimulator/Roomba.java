package com.lantopia.roombasimulator;

/**
 * An actor representing a Roomba.  This object exposes the current state of the Roomba's sensors/switches, and
 * provides control methods representing the different actions you can ask a Roomba to perform.
 */
public final class Roomba {
    public static double MaxWheelSpeed = 0.2;

    public interface Behaviour {
        /** Invoked every time the Roomba is ready for a new command.  This may be at irregular intervals, depending
         * on the state of the virtual Roomba's processor.
         * @param roombaController The roomba, with extra visible members.
         */
        void update(Controller roombaController);
    }

    public static Roomba create(Behaviour behaviour) {
        return new Roomba(behaviour);
    }


    /**
     * The 'private interface' of the Roomba.  This allows the Roomba to be controlled by its behaviour
     * script, without exposing that same functionality on the Roomba object itself (whose API represents the
     * functionality visible on a Roomba from the environment's perspective).
     */
    public final class Controller {
        public double leftWheelSpeed() { return leftWheelSpeed; }
        public double leftWheelSpeed(double v) { leftWheelSpeed = v; return leftWheelSpeed; }

        public double rightWheelSpeed() { return rightWheelSpeed; }
        public double rightWheelSpeed(double v) { rightWheelSpeed = v; return rightWheelSpeed; }
    }


    private final Behaviour behaviour;
    private final Controller controller = new Controller();

    private double leftWheelSpeed;
    private double rightWheelSpeed;


    Roomba(Behaviour behaviour) {
        this.behaviour = behaviour;
    }


    /** Indicates that someone pressed the create button on the Roomba. */
    public void start() {
        // TODO: create button stuff
    }


    /** The time of the left wheel, in m/s. */
    public double leftWheelSpeed() { return leftWheelSpeed; }

    /** The time of the right wheel, in m/s. */
    public double rightWheelSpeed() { return rightWheelSpeed; }
}
