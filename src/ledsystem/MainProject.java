package ledsystem;

import ledsystem.ledssim.LedSim;
import ledsystem.ledssim.LedStrip;

public class MainProject {

    public static void main(String[] args) {
        LedStrip realStrip = LedSim.createRows(10);


        LedController controller = new LedController(realStrip);

        WaveAnimation waveAnimation = new WaveAnimation();
        TimedAnimation timedWave = new TimedAnimation(waveAnimation, 8.0);

        controller.addAnimation(timedWave);

        new Thread(() -> {
            controller.play();
        }).start();

        while (true) {
            realStrip.apply();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
