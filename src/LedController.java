package ledsystem;
public class LedController{
    private final ledsystem.LedStrip strip;
    private ledsystem.Animation animation;

    public LedController (int stripLength)  {
        this.strip = new ledsystem.LedStrip(stripLength);
    }
    public void addAnimation(ledsystem.Animation animation){
        this.animation=animation;
    }
    public void play(){
        if (this.animation!= null){
            this.animation.apply(strip);
        }
    }
}
