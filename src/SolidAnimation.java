package ledsystem;

import java.awt.Color;

class SolidAnimation implements ledsystem.Animation {
    private final Color color;

    public SolidAnimation(Color color) {
        this.color = color;
    }

    @Override
    public void apply(MyLedStrip strip) {
        strip.setAllColors(this.color);
    }
}
