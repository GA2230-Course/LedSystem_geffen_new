package ledsystem;

import ledsystem.ledssim.LedStrip;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LedController {
    private final LedStrip strip;
    private final List<Animation> animations = new ArrayList<>();

    public LedController(LedStrip strip) {
        this.strip = Objects.requireNonNull(strip, "LedStrip cannot be null");
    }

    public void addAnimation(Animation animation) {
        this.animations.add(Objects.requireNonNull(animation, "Animation cannot be null"));
    }

    public void play() {
        for (Animation anim : animations) {

            if (anim instanceof TimedAnimation) {
                TimedAnimation timed = (TimedAnimation) anim;
                while (!timed.isFinished()) {
                    timed.apply(strip);
                    strip.apply(); // הציור קורה פה בצורה פשוטה ומסונכרנת

                    try {
                        Thread.sleep(10); // השהיה קלה ומאוזנת שמונעת Busy-Wait ומאפשרת דיוק בשעון
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            } else {
                anim.apply(strip);
                strip.apply();
            }
        }
    }
}
