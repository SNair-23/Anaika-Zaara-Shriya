
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class Block extends Actor
{
    private MayflowerImage img;
    private boolean falling;
    public Block(boolean val){
        img = new MayflowerImage("img/Tiles/2.png");
        img.scale(100,87);
        setImage(img);
        falling = val;
    }
    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();   
        
        if (falling && y>y-h) {
            setLocation (x, y-1);
        }
        
    }
}
