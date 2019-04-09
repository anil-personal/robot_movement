package com.anil.sample.robot.action;

import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.domain.Position;

public interface Action {

    void perform(final Position position) throws CanNotMoveException;

}
