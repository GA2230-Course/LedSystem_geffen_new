package ledsystem;

import java.awt.Color;
import ledsystem.ledssim.LedStrip;

public class SolidAnimation implements Animation {
    private final Color color;

    public SolidAnimation(Color color) {
        this.color = color;
    }

    @Override
    public void apply(LedStrip strip) {
        strip.setAll(this.color);
    }
}
