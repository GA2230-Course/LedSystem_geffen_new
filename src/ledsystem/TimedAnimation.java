package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.util.Objects;

public class TimedAnimation implements Animation {
    private final Animation animation;
    private final double durationSeconds;
    private final StopWatch watch = new StopWatch();
    private boolean isFirstRun = true;

    public TimedAnimation(Animation animation, double durationSeconds) {
        this.animation = Objects.requireNonNull(animation, "Animation cannot be null");
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be a positive number");
        }
        this.durationSeconds = durationSeconds;
    }

    @Override
    public void apply(LedStrip strip) {
        if (isFirstRun) {
            watch.start();
            isFirstRun = false;
        }

        if (!isFinished()) {
            animation.apply(strip);
        }
    }

    public boolean isFinished() {
        if (isFirstRun) {
            return false;
        }
        return watch.get() >= durationSeconds;
    }
}
