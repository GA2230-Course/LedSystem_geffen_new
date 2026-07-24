package ledsystem.utils;

import java.time.Instant;

public class StopWatch {

    private Double startTime = null;

    public StopWatch() {}

    public void start() {
        startTime = getTime();
    }

    public double get() {
        if (startTime == null) {
            throw new RuntimeException("HELPPPPP! Please initiate stopwatchh!");
        }
        return getTime() - this.startTime;
    }

    private double getTime() {
        return Instant.now().toEpochMilli() / 1000.0;
    }
}
