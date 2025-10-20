package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler implements MessageHandler {
    private final PrintWriter writer;

    public FileHandler(String filePath) throws IOException {
        this.writer = new PrintWriter(new FileWriter(filePath, true));
    }

    @Override
    public void log(String message) {
        writer.println(message);
    }
}
