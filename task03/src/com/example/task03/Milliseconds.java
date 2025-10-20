package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long milliseconds;

    public Milliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public long toMillis() {
        return milliseconds;
    }

    @Override
    public long toSeconds() {
        return Math.round(milliseconds / 1000f);
    }

    @Override
    public long toMinutes() {
        return Math.round(milliseconds / (float) (1000 * 60));
    }

    @Override
    public long getHours() {
        return Math.round(milliseconds / (float) (3600 * 1000));
    }
}
