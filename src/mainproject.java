package ledsystem;

public class mainproject {

    public static void main(String[] args) {
        LedController controller = new LedController(10);

        BlinkAnimation blink = new BlinkAnimation();
        WaveAnimation wave = new WaveAnimation();

        SequentialAnimationGroup group = new SequentialAnimationGroup(blink, wave);

        controller.addAnimation(group);
        controller.play();
    }
}


