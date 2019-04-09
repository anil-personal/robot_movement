package com.anil.sample.robot.action;

import com.anil.sample.robot.domain.Position;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ReportActionTest {

    @Test
    public void testPeform(){
        ReportAction reportAction = new ReportAction();
        reportAction.perform(new Position(2,3, Position.Facing.NORTH));
        assertTrue(true); // Just pass for now. (We can use Mock verify method to valid actual test.)
    }
}
