package ledsystem;

import java.awt.Color;
import java.util.Random;

public class WaveAnimation implements Animation {
    private Color c1 = null, c2 = null, cMixed = null;
    private int step = 0;

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

            System.out.println("=== START COLOR MIXING ===");
            System.out.println("Color 1 RGB: [" + c1.getRed() + ", " + c1.getGreen() + ", " + c1.getBlue() + "]");
            System.out.println("Color 2 RGB: [" + c2.getRed() + ", " + c2.getGreen() + ", " + c2.getBlue() + "]");
            System.out.println("Calculated Mixed RGB: [" + red + ", " + green + ", " + blue + "]");
            System.out.println("==========================");
        }

        if (step == 0) {
            strip.setColor(0, c1);
        } else if (step == 1) {
            strip.setColor(0, cMixed);
        } else {
            strip.setColor(0, c2);
        }

        try {
            Thread.sleep(1500);
        } catch (Exception e) {}

        if (step < 2) {
            step++;
        }
    }
}
