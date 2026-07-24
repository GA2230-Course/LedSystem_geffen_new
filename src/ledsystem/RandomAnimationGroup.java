package ledsystem;

import java.util.Random;
import ledsystem.ledssim.LedStrip;

public class RandomAnimationGroup implements Animation {
    private Animation[] animations;
    private Random random = new Random();
    private int currentIndex;

    public RandomAnimationGroup(Animation... animations) {
        this.animations = animations;
        this.currentIndex = random.nextInt(animations.length);
    }

    @Override
    public void apply(LedStrip strip) {
        Animation current = animations[currentIndex];
        current.apply(strip);

        if (current.isFinished()) {
            current.reset();
            currentIndex = random.nextInt(animations.length);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void reset() {
        for (Animation anim : animations) {
            anim.reset();
        }
        this.currentIndex = random.nextInt(animations.length);
    }
}
