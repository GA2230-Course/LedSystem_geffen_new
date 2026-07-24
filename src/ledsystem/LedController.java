package ledsystem;

import ledsystem.ledssim.LedStrip;
import java.util.ArrayList;
import java.util.List;

public class LedController {
    private final LedStrip strip;
    private final List<Animation> animations = new ArrayList<>();

    // הבנאי עכשיו מקבל את הסטריפ המוכן מבחוץ
    public LedController(LedStrip strip) {
        this.strip = strip;
    }

    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }

    public void play() {
        for (Animation anim : animations) {
            anim.reset();
            while (!anim.isFinished()) {
                anim.apply(strip);

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

