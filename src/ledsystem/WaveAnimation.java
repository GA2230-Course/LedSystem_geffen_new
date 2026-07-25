package ledsystem;

import java.awt.Color;
import java.util.Random;
import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;

public class WaveAnimation implements Animation {
    private Color c1 = null, c2 = null, cMixed = null;
    private final StopWatch sw = new StopWatch();
    private boolean isFirstRun = true;

    private void initializeColors() {
        Random r = new Random();
        c1 = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        c2 = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

        int red = (int) Math.sqrt((Math.pow(c1.getRed(), 2) + Math.pow(c2.getRed(), 2)) / 2);
        int green = (int) Math.sqrt((Math.pow(c1.getGreen(), 2) + Math.pow(c2.getGreen(), 2)) / 2);
        int blue = (int) Math.sqrt((Math.pow(c1.getBlue(), 2) + Math.pow(c2.getBlue(), 2)) / 2);

        cMixed = new Color(red, green, blue);
    }

    @Override
    public void apply(LedStrip strip) {
        if (isFirstRun) {
            sw.start();
            initializeColors();
            isFirstRun = false;
        }

        double elapsed = sw.get();

        if (elapsed < 1.5) {
            strip.setAll(c1);
        } else if (elapsed < 3.0) {
            strip.setAll(cMixed);
        } else {
            strip.setAll(c2);
        }
    }
}
