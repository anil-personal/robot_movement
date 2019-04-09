package com.anil.sample.robot.action;

import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.exception.CanNotMoveException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeftActionTest {

    @Test
    public void testPerform() throws CanNotMoveException {
        LeftAction leftAction = new LeftAction();
        Position position = new Position(0,0, Position.Facing.NORTH);
        leftAction.perform(position);
        assertEquals(0,position.getX());
        assertEquals(0,position.getY());
        assertEquals(Position.Facing.WEST,position.getFacing());

        leftAction.perform(position);
        assertEquals(Position.Facing.SOUTH,position.getFacing());

        leftAction.perform(position);
        assertEquals(Position.Facing.EAST,position.getFacing());

        leftAction.perform(position);
        assertEquals(Position.Facing.NORTH,position.getFacing());
    }
}
