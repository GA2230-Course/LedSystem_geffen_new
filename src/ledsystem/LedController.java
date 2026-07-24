package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LedController {
    private final LedStrip strip;
    private final List<TimedAnimation> timedAnimations = new ArrayList<>();

    public LedController(LedStrip strip) {
        this.strip = Objects.requireNonNull(strip, "LedStrip cannot be null");
    }

    public void addAnimation(TimedAnimation timedAnimation) {
        this.timedAnimations.add(Objects.requireNonNull(timedAnimation, "TimedAnimation cannot be null"));
    }

    public void play() {
        StopWatch watch = new StopWatch();

        for (TimedAnimation timedAnim : timedAnimations) {
            watch.start();
            double duration = timedAnim.getDurationSeconds();
            Animation anim = timedAnim.getAnimation();

            double elapsed;
            while ((elapsed = watch.get()) < duration) {
                anim.apply(strip, elapsed);
                strip.apply();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}
