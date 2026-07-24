package ledsystem;

import java.awt.*;

public class BlinkAnimation implements Animation {
    private boolean isColorA = true;
    private int framesCount = 0;
    private boolean finished = false;

    public BlinkAnimation() {
    }

    @Override
    public void apply(MyLedStrip strip) {
        if (finished) return;

        if (framesCount % 20 == 0) {
            Color nextColor = isColorA ? Color.RED : Color.GREEN;
            for (int i = 0; i < strip.getLength(); i++) {
                strip.setColor(i, nextColor);
            }
            isColorA = !isColorA;
        }

        framesCount++;

        if (framesCount >= 50) {
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public void reset() {
        this.framesCount = 0;
        this.isColorA = true;
        this.finished = false;
    }
}
