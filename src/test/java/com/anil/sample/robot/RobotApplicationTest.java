package com.anil.sample.robot;

import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.input.FileDataInput;
import com.anil.sample.robot.input.Input;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RobotApplicationTest {

    RobotApplication robotApplication;

    @Before
    public void setUp() {
        robotApplication = new RobotApplication();
    }


    @Test
    public void testScenario1() {
        List<String> commands = getCommands("fileinput/test-commands1.txt");
        robotApplication.submitCommands(commands);
        assertEquals(new Position(0, 1, Position.Facing.NORTH), robotApplication.getPosition());
    }

    @Test
    public void testScenario2() {
        List<String> commands = getCommands("fileinput/test-commands2.txt");
        robotApplication.submitCommands(commands);
        assertEquals(new Position(0, 0, Position.Facing.WEST), robotApplication.getPosition());
    }

    @Test
    public void testScenario3() {
        List<String> commands = getCommands("fileinput/test-commands3.txt");
        robotApplication.submitCommands(commands);
        assertEquals(new Position(3, 3, Position.Facing.NORTH), robotApplication.getPosition());
    }

    private List<String> getCommands(String filePath) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        String file = classLoader.getResource(filePath).getFile();
        Input input = new FileDataInput(file);
        return input.getInput();
    }

}
