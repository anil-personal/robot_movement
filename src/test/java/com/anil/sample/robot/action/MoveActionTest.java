package com.anil.sample.robot.action;

import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.exception.CanNotMoveException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MoveActionTest {

    @Test
    public void testPerform_north() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(0, 0, Position.Facing.NORTH);
        moveAction.perform(position);
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Position.Facing.NORTH, position.getFacing());
    }

    @Test(expected = CanNotMoveException.class)
    public void testPerform_north_onEdge() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(0, 5, Position.Facing.NORTH);
        moveAction.perform(position);
        fail("Exception should have thrown in above line");
    }

    @Test
    public void testPerform_south() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(1, 1, Position.Facing.SOUTH);
        moveAction.perform(position);
        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Position.Facing.SOUTH, position.getFacing());
    }

    @Test(expected = CanNotMoveException.class)
    public void testPerform_south_onEdge() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(0, 0, Position.Facing.SOUTH);
        moveAction.perform(position);
        fail("Exception should have thrown in above line");
    }

    @Test
    public void testPerform_west() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(2, 2, Position.Facing.WEST);
        moveAction.perform(position);
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Position.Facing.WEST, position.getFacing());
    }

    @Test(expected = CanNotMoveException.class)
    public void testPerform_west_onEdge() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(0, 0, Position.Facing.WEST);
        moveAction.perform(position);
        fail("Exception should have thrown in above line");
    }

    @Test
    public void testPerform_east() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(2, 2, Position.Facing.EAST);
        moveAction.perform(position);
        assertEquals(3, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Position.Facing.EAST, position.getFacing());
    }

    @Test(expected = CanNotMoveException.class)
    public void testPerform_east_onEdge() throws CanNotMoveException {
        MoveAction moveAction = new MoveAction();
        Position position = new Position(5, 0, Position.Facing.EAST);
        moveAction.perform(position);
        fail("Exception should have thrown in above line");
    }
}
