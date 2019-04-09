package com.anil.sample.robot.action;

import com.anil.sample.robot.domain.Position;
import org.apache.log4j.Logger;

import java.util.Locale;

public class ReportAction implements Action {
    private final static Logger logger = Logger.getLogger(ReportAction.class);

    public void perform(final Position position){
        logger.info(String.format(Locale.getDefault(), "Current Position : %s", position));
    }
}
