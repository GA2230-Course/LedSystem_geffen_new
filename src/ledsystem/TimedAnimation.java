package ledsystem;

import ledsystem.ledssim.LedStrip;
import java.util.Objects;

public class TimedAnimation {
    private final Animation animation;
    private final double durationSeconds;

    public TimedAnimation(Animation animation, double durationSeconds) {
        this.animation = Objects.requireNonNull(animation, "Animation cannot be null");
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be a positive number");
        }
        this.durationSeconds = durationSeconds;
    }

    public Animation getAnimation() {
        return this.animation;
    }

    public double getDurationSeconds() {
        return this.durationSeconds;
    }
}
