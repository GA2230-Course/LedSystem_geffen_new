package ledsystem;

import ledsystem.ledssim.LedStrip;
import java.awt.Color;

public class BlinkAnimation implements Animation {
    private final Color colorA;
    private final Color colorB;
    private final double intervalSeconds;

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
    public void apply(LedStrip strip, double elapsedSeconds) {
        long pulse = (long) (elapsedSeconds / intervalSeconds);

        if (pulse % 2 == 0) {
            strip.setAll(colorA);
        } else {
            strip.setAll(colorB);
        }
    }
}
