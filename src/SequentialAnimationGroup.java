package ledsystem;

public class SequentialAnimationGroup implements Animation {
    private Animation[] animations;
    private int currentIndex = 0;

    public SequentialAnimationGroup(Animation... animations) {
        this.animations = animations;
    }

    @Override
    public void apply(MyLedStrip strip) {
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
}
