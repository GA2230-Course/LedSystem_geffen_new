package ledsystem;

import java.awt.Color;

public class mainproject {

    public static void main(String[] args) {
        LedController controller = new LedController(10);

        WaveAnimation waveAnimation = new WaveAnimation();

        controller.addAnimation(waveAnimation);
        controller.play();
    }
}


