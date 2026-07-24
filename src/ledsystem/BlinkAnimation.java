package ledsystem;

import ledsystem.utils.StopWatch;
import ledsystem.ledssim.LedStrip;
import java.awt.*;

public class BlinkAnimation implements Animation {
    private final StopWatch sw = new StopWatch();
    private boolean isColorA = true;
    private double targetTime = 2.0;
    private boolean isFirstRun = true;

    public BlinkAnimation() {
    }

    @Override
    public void apply(LedStrip strip) {
        if (isFirstRun) {
            sw.start();
            isFirstRun = false;
        }

        if (sw.get() >= targetTime) {
            Color nextColor = isColorA ? Color.RED : Color.GREEN;

            strip.setAll(nextColor);

            isColorA = !isColorA;
            targetTime += 2.0;
        }
    }
    @Override
    public boolean isFinished() {
        return sw.get() >= 7.0;
    }

}
