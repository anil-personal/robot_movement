package com.anil.sample.robot.action;

import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.domain.Position;

public class LeftAction implements Action {

    public void perform(final Position position) throws CanNotMoveException {
        switch (position.getFacing()) {
            case NORTH:
                position.setFacing(Position.Facing.WEST);
                return;
            case WEST:
                position.setFacing(Position.Facing.SOUTH);
                return;
            case SOUTH:
                position.setFacing(Position.Facing.EAST);
                return;
            case EAST:
                position.setFacing(Position.Facing.NORTH);
                return;
            default:
                // If any new enum code is added in future. This class should get noticed.
                throw new UnsupportedOperationException("Not implemented");
        }
    }
}
