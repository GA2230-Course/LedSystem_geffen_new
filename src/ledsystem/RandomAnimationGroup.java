package ledsystem;

import java.util.Random;

public class RandomAnimationGroup implements Animation {
    private Animation[] animations;
    private Random random = new Random();
    private int currentIndex;

    public RandomAnimationGroup(Animation... animations) {
        this.animations = animations;
        this.currentIndex = random.nextInt(animations.length);
    }

    @Override
    public void apply(MyLedStrip strip) {
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
}
