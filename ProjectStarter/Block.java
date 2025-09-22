
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class Block extends Actor
{
    private boolean falling;
    public Block(boolean val){
        setImage("img/Tiles/2.png");
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
