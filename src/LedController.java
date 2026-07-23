package ledsystem;

public class LedController {
    private final ledsystem.MyLedStrip strip;
    private ledsystem.Animation animation;

    public LedController (int stripLength)  {
        this.strip = new ledsystem.MyLedStrip(stripLength);
    }

    public void addAnimation(ledsystem.Animation animation){
        this.animation = animation;
    }

    public void play(){
        while (this.animation != null){
            this.animation.apply(strip);
        }
    }
}

