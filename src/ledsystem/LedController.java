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
        for (Animation animation : animations) {
            animation.apply(strip);
        }
    }
}
