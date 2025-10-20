package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String path;
    private final ChronoUnit rotation;
    public RotationFileHandler(String path, ChronoUnit rotation) {
        this.path = path;
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(rotation);
        File file = new File(path + date.toString().replace(':','#') + ".txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(message.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
