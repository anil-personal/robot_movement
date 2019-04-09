package com.anil.sample.robot.action;

import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.domain.Position;

/**
 * Why Interface?
 * Because Robot can be programmed to much more than move,left,right and report.
 * (It can flip, shoot or fly in future. )
 */
public interface Action {

    void perform(final Position position) throws CanNotMoveException;

}
