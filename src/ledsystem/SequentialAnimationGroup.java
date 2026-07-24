package ledsystem;

import ledsystem.ledssim.LedStrip;

public class SequentialAnimationGroup implements Animation {
    private Animation[] animations;
    private int currentIndex = 0;

    public SequentialAnimationGroup(Animation... animations) {
        this.animations = animations;
    }

    @Override
    public void apply(LedStrip strip) {
        if (isFinished()) {
            return;
        }

        Animation current = animations[currentIndex];
        current.apply(strip);

        if (current.isFinished()) {
            currentIndex++;
        }
    }

    @Override
    public boolean isFinished() {
        return currentIndex >= animations.length;
    }

    @Override
    public void reset() {
        currentIndex = 0;
        for (Animation anim : animations) {
            anim.reset();
        }
    }
}
