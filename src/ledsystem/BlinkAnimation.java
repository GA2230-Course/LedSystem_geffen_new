package ledsystem;

import java.awt.*;
import ledsystem.ledssim.LedStrip;

public class BlinkAnimation implements Animation {
    private boolean isColorA = true;
    private int framesCount = 0;
    private boolean finished = false;

    public BlinkAnimation() {
    }

    @Override
    public void apply(LedStrip strip) {
        if (finished) return;

        if (framesCount % 20 == 0) {
            Color nextColor = isColorA ? Color.RED : Color.GREEN;
            strip.setAll(nextColor);
            isColorA = !isColorA;
        }

        framesCount++;

        if (framesCount >= 70) {
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
