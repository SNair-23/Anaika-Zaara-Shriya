
/**
 * Write a description of class AnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class AnimatedActor extends Actor
{
    // instance variables - replace the example below with your own
    private Animation animation;
    private Timer animationTimer;
    public AnimatedActor(){
        animationTimer = new Timer(10000000);
    }   
    public void setAnimation(Animation a){
        animation = a;
    }
    public void act()
    {
        if (animationTimer.isDone()){
            MayflowerImage p = animation.getNextFrame();
            setImage(p);
        }
    }
}
