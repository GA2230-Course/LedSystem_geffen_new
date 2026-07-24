package ledsystem;

import ledsystem.ledssim.LedSim;
import ledsystem.ledssim.LedStrip;

public class MainProject {

    public static void main(String[] args) {
        java.awt.Point[] points = new java.awt.Point[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new java.awt.Point(i * 20, 50);
        }
        LedStrip realStrip = new LedSim(points);

        LedController controller = new LedController(realStrip);

        WaveAnimation waveAnimation = new WaveAnimation();
        TimedAnimation timedWave = new TimedAnimation(waveAnimation, 8.0);

        controller.addAnimation(timedWave);
        controller.play();
    }
}
