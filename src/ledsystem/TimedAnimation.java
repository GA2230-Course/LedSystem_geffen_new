package ledsystem;

import ledsystem.utils.StopWatch;
import ledsystem.ledssim.LedStrip;

public class TimedAnimation implements Animation {
    private final Animation animation;
    private final double durationSeconds;
    private final StopWatch watch = new StopWatch();
    private boolean isFirstRun = true;

    public TimedAnimation(Animation animation, double durationSeconds) {
        this.animation = animation;
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

    @Override
    public boolean isFinished() {
        if (isFirstRun) {
            return false;
        }
        return watch.get() >= durationSeconds || animation.isFinished();
    }

    @Override
    public void reset() {
        this.isFirstRun = true;
        this.animation.reset();
    }
}
