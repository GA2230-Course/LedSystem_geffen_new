package ledsystem;

import java.awt.Color;
import java.util.Random;
import ledsystem.ledssim.LedStrip;

public class WaveAnimation implements Animation {
    private Color c1 = null, c2 = null, cMixed = null;
    private int step = 0;

    @Override
    public void apply(LedStrip strip) {
        if (c1 == null) {
            Random r = new Random();
            c1 = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            c2 = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

            int red = (int) Math.sqrt((Math.pow(c1.getRed(), 2) + Math.pow(c2.getRed(), 2)) / 2);
            int green = (int) Math.sqrt((Math.pow(c1.getGreen(), 2) + Math.pow(c2.getGreen(), 2)) / 2);
            int blue = (int) Math.sqrt((Math.pow(c1.getBlue(), 2) + Math.pow(c2.getBlue(), 2)) / 2);

            cMixed = new Color(red, green, blue);
        }

        if (step == 0) {
            strip.setAll(c1);
        } else if (step == 1) {
            strip.setAll(cMixed);
        } else {
            strip.setAll(c2);
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        if (step < 2) {
            step++;
        }
    }
}
