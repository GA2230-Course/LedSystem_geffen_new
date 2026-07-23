package ledsystem;
import java.awt.Color;

public class mainproject {
    public static void main(String[] args) {
        ledsystem.LedStrip myStrip = new ledsystem.LedStrip(10);
        LedController controller = new LedController(10);
        SolidAnimation redAnimation = new SolidAnimation(Color.red);
        redAnimation.apply(myStrip);
        controller.addAnimation(redAnimation);
        controller.play();
    }
}
