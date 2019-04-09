package com.anil.sample.robot.action;

import com.anil.sample.robot.domain.Position;

/**
 * Report Action
 * Robot reports it's position to standard output
 */
public class ReportAction implements Action {
    public void perform(final Position position){
        System.out.println(position);
    }
}
