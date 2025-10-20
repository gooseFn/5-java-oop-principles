package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final int maxSize;
    private final ArrayList<String> messages = new ArrayList<>();
    private final MessageHandler proxyHandler;
    public MemoryHandler(MessageHandler proxyHandler, int maxSize) {
        this.proxyHandler = proxyHandler;
        this.maxSize = maxSize;
    }

    public void flush() {
        for (String message : messages) {
            proxyHandler.log(message);
        }
        messages.clear();
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() >= maxSize) {
            flush();
        }
    }

}
