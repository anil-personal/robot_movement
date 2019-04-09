package com.anil.sample.robot;

import com.anil.sample.robot.action.LeftAction;
import com.anil.sample.robot.action.MoveAction;
import com.anil.sample.robot.action.ReportAction;
import com.anil.sample.robot.action.RightAction;
import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.domain.Robot;
import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.exception.NotPlacedException;

/**
 * Robot movement class.
 * <p>
 * Hold Robot instance and allow caller to invoke operation/actions on the Robot class.
 */
public class RobotMovement {

    /**
     * Robot instance.
     */
    private Robot robot;

    // We can make this lazy-init (or take out to builder/factory class).
    // Holding reference to avoid creating multiple instance of Actions.
    // Any way, actions are not holding any stateful resource. So cache it.
    private LeftAction leftAction = new LeftAction();
    private RightAction rightAction = new RightAction();
    private MoveAction moveAction = new MoveAction();
    private ReportAction reportAction = new ReportAction();

    /**
     * Place the robot to particular position
     *
     * @param position the position
     */
    public void place(Position position) {
        if (robot == null) {
            robot = new Robot(position);
        } else {
            // TODO : Can we place robot twice?
            throw new UnsupportedOperationException("Robot is already placed");
        }

    }

    /**
     * Turn Left (anti clockwise) without moving.
     *
     * @throws CanNotMoveException turning left is not possible.
     * @throws NotPlacedException  when Robot is not placed.
     */
    public void left() throws CanNotMoveException, NotPlacedException {
        if (robot != null) {
            robot.perform(leftAction);
        } else {
            // Let caller decide, what to do with this exception.
            throw new NotPlacedException("Robot not placed");
        }
    }

    /**
     * Turn Right (clockwise) without moving.
     *
     * @throws CanNotMoveException turning right is not possible.
     * @throws NotPlacedException  when Robot is not placed.
     */
    public void right() throws CanNotMoveException, NotPlacedException {
        if (robot != null) {
            robot.perform(rightAction);
        } else {
            // Let caller decide, what to do with this exception.
            throw new NotPlacedException("Robot not placed");
        }
    }

    /**
     * Move one step (on the direction it is facing).
     *
     * @throws CanNotMoveException when moving is not possible.
     * @throws NotPlacedException  when Robot is not placed.
     */
    public void move() throws CanNotMoveException, NotPlacedException {
        if (robot != null) {
            robot.perform(moveAction);
        } else {
            // Let caller decide, what to do with this exception.
            throw new NotPlacedException("Robot not placed");
        }
    }

    /**
     * Move one step (on the direction it is facing).
     *
     * @throws CanNotMoveException This will not be thrown.
     * @throws NotPlacedException  when Robot is not placed.
     */
    public void report() throws CanNotMoveException, NotPlacedException {
        if (robot != null) {
            robot.perform(reportAction);
        } else {
            // Let caller decide, what to do with this exception.
            throw new NotPlacedException("Robot not placed");
        }
    }

    /**
     * Get Position
     * @return the position of the null.
     * (Null if robot is not placed.)
     */
    public Position getPosition() {
        if (robot != null) {
            return robot.getPosition();
        }
        return null;
    }

}
