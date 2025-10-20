package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    private final String name;
    private ErrorLevel level;
    private static final ArrayList<Logger> loggers = new ArrayList<>();
    private static ArrayList<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name) {
        this.name = name;
        this.level = ErrorLevel.INFO;
        loggers.add(this);
        handlers.add(new ConsoleHandler());
    }

    public Logger(String name, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        this.level = ErrorLevel.INFO;
        handlers = messageHandlers;
        loggers.add(this);
    }

    public Logger(String name, ErrorLevel level, ArrayList<MessageHandler> messageHandlers) {
        this.name = name;
        this.level = level;
        handlers = messageHandlers;
        loggers.add(this);
    }

    public String getName() {
        return name;
    }

    public ErrorLevel getLevel() {
        return level;
    }

    public void setLevel(ErrorLevel level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.getName().equals(name)) return logger;
        }
        return new Logger(name);
    }

    public void log(ErrorLevel level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String formattedMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, dateTime, name, message);
            for (MessageHandler messageHandler : handlers)
                messageHandler.log(formattedMessage);
        }
    }

    public void log(ErrorLevel level, String pattern, Object... args) {
        if (this.level.ordinal() <= level.ordinal()) {
            String message = MessageFormat.format(pattern, args);
            for (MessageHandler messageHandler : handlers)
                messageHandler.log(message);
        }
    }

    public void debug(String message) {
        log(ErrorLevel.DEBUG, message);
    }

    public void debug(String pattern, Object... args) {
        log(ErrorLevel.DEBUG, pattern, args);
    }

    public void info(String message) {
        log(ErrorLevel.INFO, message);
    }

    public void info(String pattern, Object... args) {
        log(ErrorLevel.INFO, pattern, args);
    }

    public void warning(String message) {
        log(ErrorLevel.WARNING, message);
    }

    public void warning(String pattern, Object... args) {
        log(ErrorLevel.WARNING, pattern, args);
    }

    public void error(String message) {
        log(ErrorLevel.ERROR, message);
    }

    public void error(String pattern, Object... args) {
        log(ErrorLevel.ERROR, pattern, args);
    }
}