package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.awt.Color;

public class BlinkAnimation implements Animation {
    private final Color colorA;
    private final Color colorB;
    private final double intervalSeconds;
    private final StopWatch sw = new StopWatch();
    private boolean isFirstRun = true;

    public BlinkAnimation() {
        this(Color.RED, Color.GREEN, 2.0);
    }

    public BlinkAnimation(Color colorA, Color colorB, double intervalSeconds) {
        if (intervalSeconds <= 0) {
            throw new IllegalArgumentException("Interval must be positive");
        }
        this.colorA = colorA;
        this.colorB = colorB;
        this.intervalSeconds = intervalSeconds;
    }

    @Override
    public void apply(LedStrip strip) {
        if (isFirstRun) {
            sw.start();
            isFirstRun = false;
        }

        double elapsed = sw.get();
        long pulse = (long) (elapsed / intervalSeconds);

        if (pulse % 2 == 0) {
            strip.setAll(colorA);
        } else {
            strip.setAll(colorB);
        }
    }
}
