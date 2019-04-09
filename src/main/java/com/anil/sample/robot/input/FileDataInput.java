package com.anil.sample.robot.input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reading input from a file.
 */
public class FileDataInput implements Input {

    private final String filePath;

    public FileDataInput(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getInput() {
        List<String> commands = new ArrayList<String>();
        File file = new File(filePath);
        BufferedReader b = null;
        try {
            b = new BufferedReader(new FileReader(file));

            String readLine;
            while ((readLine = b.readLine()) != null) {
                commands.add(readLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading input.", e);
        }
        return commands;
    }

}
