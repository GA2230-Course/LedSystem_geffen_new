package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.util.Objects;

public class TimedAnimation implements Animation {
    private final Animation animation;
    private final double durationSeconds;

    public TimedAnimation(Animation animation, double durationSeconds) {
        this.animation = Objects.requireNonNull(animation, "Animation cannot be null");
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be a positive number");
        }
        this.durationSeconds = durationSeconds;
    }

    @Override
    public void apply(LedStrip strip) {
        StopWatch watch = new StopWatch();
        watch.start();

        while (watch.get() < durationSeconds) {
            animation.apply(strip);
            strip.apply();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
