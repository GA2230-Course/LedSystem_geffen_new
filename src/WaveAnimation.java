package ledsystem;

import java.awt.Color;
import java.util.Random;

public class WaveAnimation implements Animation {
    private Color c1 = null, c2 = null, cMixed = null;
    private int step = 0;
    private int framesCount = 0;

    @Override
    public void apply(MyLedStrip strip) {
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
            strip.setColor(0, c1);
        } else if (step == 1) {
            strip.setColor(0, cMixed);
        } else {
            strip.setColor(0, c2);
        }

        framesCount++;

        // כל 15 פריימים (בערך שנייה וחצי) נעבור לצבע הבא בתור
        if (framesCount >= 15) {
            if (step < 3) {
                step++;
            }
            framesCount = 0;
        }
    }

    @Override
    public boolean isFinished() {
        return step >= 3;
    }

    @Override
    public void reset() {
        this.step = 0;
        this.framesCount = 0;
        this.c1 = null;
        this.c2 = null;
        this.cMixed = null;
    }
}
