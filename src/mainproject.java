package ledsystem;

import java.awt.Color;

public class mainproject {

    public static void main(String[] args) {
        LedController controller = new LedController(10);

        BlinkAnimation blinkAnimation = new BlinkAnimation(Color.RED, Color.GREEN, 2.0);

        controller.addAnimation(blinkAnimation);
        controller.play();
    }
}


