package com.lantopia.roombasimulator.test;


import com.lantopia.roombasimulator.Roomba;
import com.lantopia.roombasimulator.Simulation;

import org.junit.Test;

import static com.lantopia.roombasimulator.controllers.SimpleControllers.simpleRicochetController;
import static org.assertj.core.api.Assertions.assertThat;

/** Integration tests for this module */
public class ModuleTest {
    private Roomba roomba;
    private Simulation simulation;

    @Test
    public void emptyRoomTest() {
        // In this test, the Roomba should create in the middle of the left end of the room, facing right.  It should
        // leave the dock, turn 180 degrees, and travel forward until it hits the opposite wall 10 metres away. it
        // should then bounce off, turn 180 degrees, and return to the dock successfully.

        this.roomba = Roomba.create(simpleRicochetController());
        this.simulation = emptyRoomWithRoombaInIt(10, 10, 0, 5, 90.0, roomba);

        simulation.time(0);
        simulation.startRoomba();

        // should be moving to the right normally
        validateMotionAtTime(10, 90.0, Roomba.MaxWheelSpeed, Roomba.MaxWheelSpeed);

        // should have bounced off the far wall and be moving back to the left
        validateMotionAtTime(60, 270.0, Roomba.MaxWheelSpeed, Roomba.MaxWheelSpeed);

        // should be back on the dock
        validateMotionAtTime(120, 90.0, 0, 0);
    }

    private Simulation emptyRoomWithRoombaInIt(double width, double height, double dockX, double dockY, double dockOrientation, Roomba roomba) {
        // TODO: fill this out
        return null;
    }

    void validateMotionAtTime(double time, double orientation, double leftSpeed, double rightSpeed) {
        simulation.time(time);
        assertThat(simulation.roombaOrientation()).isEqualTo(orientation);
        assertThat(roomba.leftWheelSpeed()).isEqualTo(leftSpeed);
        assertThat(roomba.rightWheelSpeed()).isEqualTo(rightSpeed);
    }
}
