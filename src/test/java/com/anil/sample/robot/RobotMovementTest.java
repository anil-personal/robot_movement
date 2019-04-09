package com.anil.sample.robot;

import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.exception.NotPlacedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotMovementTest {

    RobotMovement robotMovement;

    @Before
    public void setUp(){
        robotMovement = new RobotMovement();
    }

    @Test
    public void testScenario1() throws NotPlacedException, CanNotMoveException {
        robotMovement.place(new Position(0,0, Position.Facing.NORTH));
        assertEquals(new Position(0,0, Position.Facing.NORTH),robotMovement.getPosition());

        robotMovement.left();
        assertEquals(new Position(0,0, Position.Facing.WEST),robotMovement.getPosition());

        robotMovement.right();
        assertEquals(new Position(0,0, Position.Facing.NORTH),robotMovement.getPosition());

        robotMovement.move();
        assertEquals(new Position(0,1, Position.Facing.NORTH),robotMovement.getPosition());

        robotMovement.right();
        assertEquals(new Position(0,1, Position.Facing.EAST),robotMovement.getPosition());

        robotMovement.move();
        assertEquals(new Position(1,1, Position.Facing.EAST),robotMovement.getPosition());
    }

}
