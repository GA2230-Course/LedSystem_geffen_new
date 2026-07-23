package ledsystem;

import ledsystem.utils.StopWatch;
import java.awt.*;

public class BlinkAnimation implements ledsystem.Animation {
    private final StopWatch sw = new StopWatch();
    private final Color colorA;
    private final Color colorB;
    private final double delay;
    private boolean isColorA = true;
    private double targetTime;
    private boolean isFirstRun = true;

    public BlinkAnimation(Color colorA, Color colorB, double delay) {
        this.colorA = colorA;
        this.colorB = colorB;
        this.delay = delay;
        this.targetTime = delay;
    }

    @Override
    public void apply(ledsystem.LedStrip strip) {
        if (isFirstRun) {
            sw.start();
            isFirstRun = false;
        }

        if (sw.get() >= targetTime) {
            Color nextColor;
            if (isColorA) {
                nextColor = colorA;
            } else {
                nextColor = colorB;
            }

            strip.setAllColors(nextColor);

            isColorA = !isColorA;
            targetTime += delay;
        }
    }
}
