package com.anil.sample.robot;

import com.anil.sample.robot.input.FileDataInput;
import com.anil.sample.robot.input.Input;

import java.util.List;

/**
 *  Main Application class
 */
public class RobotApplication {

    RobotMovement robotMovement = new RobotMovement();

    public static void main(String s[]) {
        RobotApplication robotApplication = new RobotApplication();
        Input input = new FileDataInput("fileinput/scenario1.txt");
        List<String> commands = input.getInput();
        commands.forEach(command -> robotApplication.invokeCommand(command));
    }

    private void invokeCommand(String command) {
        // TODO : Invoke command on RobotMovement.
    }

}
