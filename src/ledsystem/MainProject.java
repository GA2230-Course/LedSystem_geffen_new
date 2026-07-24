package ledsystem;

import ledsystem.ledssim.LedSim;
import ledsystem.ledssim.LedStrip;

public class MainProject {

    public static void main(String[] args) {
        java.awt.Point[] points = new java.awt.Point[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new java.awt.Point(i * 30 + 10, 100);
        }
        LedStrip realStrip = new LedSim(points);

        LedController controller = new LedController(realStrip);

        BlinkAnimation blink = new BlinkAnimation();
        WaveAnimation wave = new WaveAnimation();

        SequentialAnimationGroup sequentialGroup = new SequentialAnimationGroup(blink, wave);
        TimedAnimation timedSequence = new TimedAnimation(sequentialGroup, 20.0);

        controller.addAnimation(timedSequence);
        controller.play();
    }
}
