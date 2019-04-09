package com.anil.sample.robot;

import com.anil.sample.robot.domain.Position;
import com.anil.sample.robot.exception.CanNotMoveException;
import com.anil.sample.robot.exception.NotPlacedException;
import com.anil.sample.robot.input.FileDataInput;
import com.anil.sample.robot.input.Input;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Main Application class
 * To update the command goes to PROJECT_ROOT/src/main/resources/fileinput/commands.txt
 */
public class RobotApplication {

    RobotMovement robotMovement = new RobotMovement();

    public static void main(String s[]) {
        RobotApplication robotApplication = new RobotApplication();
        ClassLoader classLoader = RobotApplication.class.getClassLoader();
        String file = classLoader.getResource("fileinput/commands.txt").getFile();
        Input input = new FileDataInput(file);
        List<String> commands = input.getInput();
        robotApplication.submitCommands(commands);
    }

    /**
     * Submit commands to Robot.
     * In case of exception, the individual command will be ignored and moved to next.
     *
     * @param commands the commands
     */
    public void submitCommands(List<String> commands) {
        commands.forEach(command -> submitCommand(command));
    }

    /**
     * Submit a command to Robot.
     * In case of exception, the command will be ignored.
     *
     * @param command the command
     */
    public void submitCommand(String command) {
        // TODO: Need better way to parse commands.
        try {
            if (command == null || command.trim().equals("")) {
                return;
            } else if (command.trim().equalsIgnoreCase("MOVE")) {
                robotMovement.move();
            } else if (command.trim().equalsIgnoreCase("LEFT")) {
                robotMovement.left();
            } else if (command.trim().equalsIgnoreCase("RIGHT")) {
                robotMovement.right();
            } else if (command.trim().equalsIgnoreCase("REPORT")) {
                robotMovement.report();
            } else if (command.trim().startsWith("PLACE")) {
                // TODO: Use Regex or other better way.
                int x;
                int y;
                Position.Facing facing;
                try {
                    String position = command.substring(6);
                    StringTokenizer st = new StringTokenizer(position, ",");
                    x = Integer.valueOf(st.nextToken());
                    y = Integer.valueOf(st.nextToken());
                    facing = Position.Facing.fromString(st.nextToken());
                } catch (Exception e) {
                    // TODO : Need better error handling.
                    System.out.println("Error while decoding PLACE " + e.getMessage());
                    return;
                }
                robotMovement.place(new Position(x, y, facing));
            }
        } catch (CanNotMoveException | NotPlacedException ignore) {
            System.out.println("Ignored : " + command);
        }
    }

    /**
     * Get Position of robot
     *
     * @return the position
     */
    protected Position getPosition() {
        return robotMovement.getPosition();
    }


}
