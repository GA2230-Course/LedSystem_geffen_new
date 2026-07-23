package ledsystem;

import java.awt.Color;

public class mainproject {
    public static void main(String[] args) {


        MyLedStrip myStrip = new MyLedStrip(10);
        SolidAnimation redAnimation = new ledsystem.SolidAnimation(Color.RED);
        redAnimation.apply(myStrip);
    }
}
