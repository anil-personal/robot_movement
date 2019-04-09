package com.anil.sample.robot.action;

import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.domain.Position;

public class MoveAction implements Action {

    public void perform(final Position position) throws CanNotMoveException {
        switch (position.getFacing()) {
            case EAST:
                if (position.getX() >= position.getMaxX()) {
                    throw new CanNotMoveException("Robot is already on the east side edge.");
                }
                position.setX(position.getX() + 1);
                return;
            case WEST:
                if (position.getX() <= 0) {
                    throw new CanNotMoveException("Robot is already on the west side edge.");
                }
                position.setX(position.getX() - 1);
                break;
            case NORTH:
                if (position.getY() >= position.getMaxY()) {
                    throw new CanNotMoveException("Robot is already on the north side edge.");
                }
                position.setY(position.getY() + 1);
                return;
            case SOUTH:
                if (position.getY() <= 0) {
                    throw new CanNotMoveException("Robot is already on the south side edge.");
                }
                position.setY(position.getY() - 1);
                break;
            default:
                // If any new enum code is added in future. This class should get noticed.
                throw new UnsupportedOperationException("Not implemented");
        }
    }
}
