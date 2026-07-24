package ledsystem;

public class mainproject {

    public static void main(String[] args) {
        LedController controller = new LedController(10);

        BlinkAnimation blink = new BlinkAnimation();
        WaveAnimation wave = new WaveAnimation();

        RandomAnimationGroup  group = new RandomAnimationGroup (blink, wave);

        controller.addAnimation(group);
        controller.play();
    }
}


