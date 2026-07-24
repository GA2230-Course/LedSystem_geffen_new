package ledsystem;
import ledsystem.utils.StopWatch;

public class LedController {
    private final MyLedStrip strip;
    private Animation animation;
    private final StopWatch globalWatch = new StopWatch();

    public LedController (int stripLength)  {
        this.strip = new MyLedStrip(stripLength);
    }
    public void addAnimation(Animation animation){
        this.animation = animation;
    }

    public void play(){
        this.globalWatch.start();

        while (this.animation != null && globalWatch.get() < 20.0) {
            this.animation.apply(strip);
            System.out.println("the past time is:" + globalWatch.get());
        }
    }
}



