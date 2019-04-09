package com.anil.sample.robot.action;

import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.exception.CanNotMoveException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightActionTest {
    @Test
    public void testPerform() throws CanNotMoveException {
        RightAction rightAction = new RightAction();
        Position position = new Position(0,0, Position.Facing.NORTH);
        rightAction.perform(position);
        assertEquals(0,position.getX());
        assertEquals(0,position.getY());
        assertEquals(Position.Facing.EAST,position.getFacing());

        rightAction.perform(position);
        assertEquals(Position.Facing.SOUTH,position.getFacing());

        rightAction.perform(position);
        assertEquals(Position.Facing.WEST,position.getFacing());

        rightAction.perform(position);
        assertEquals(Position.Facing.NORTH,position.getFacing());
    }
}
