package ledsystem;

import ledsystem.utils.StopWatch;

import java.awt.*;

public class BlinkAnimation implements Animation {
    private final StopWatch sw = new StopWatch();
    private boolean isColorA = true;
    private double targetTime = 2.0;
    private boolean isFirstRun = true;


    public BlinkAnimation() {

    }

    @Override
    public void apply(MyLedStrip strip) {
        if (isFirstRun) {
            sw.start();
            isFirstRun = false;
        }

        if (sw.get() >= targetTime) {
            Color nextColor;
            if (isColorA) {
                nextColor = Color.RED;
            } else {
                nextColor = Color.GREEN;
            }


            for (int i = 0; i < strip.getLength(); i++) {
                strip.setColor(i, nextColor);
            }

            isColorA = !isColorA;
            targetTime += 2.0;
        }
    }
}
