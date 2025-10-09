
/**
 * Write a description of class Portal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class Portal extends Actor
{
    private MayflowerImage img;
    private boolean falling;
    public Portal(boolean val){
        img = new MayflowerImage("img/portal.png");
        img.scale(100,60);
        setImage(img);
        falling = val;
    }
    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();   
        
        if (falling) {
            setLocation (x, y-1);
        }
        
    }
}