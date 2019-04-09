package com.anil.sample.robot.domain;

import com.anil.sample.robot.action.Action;
import com.anil.sample.robot.exception.CanNotMoveException;

/**
 * Robot class
 */
public class Robot {

    /**
     * Position of the Robot.
     * final? (Because Robot can not hold ground without position.)
     */
    private final Position position;

    public Robot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void perform(Action action) throws CanNotMoveException {
        action.perform(position);
    }
}
