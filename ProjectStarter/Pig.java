
/**
 * Write a description of class Pig here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class Pig extends Actor
{
    // instance variables - replace the example below with your own
    private MayflowerImage img;
    public Pig(boolean val)
    {
        img = new MayflowerImage("img/enemy.png");
        img.scale(60,40);
        setImage(img);
        
    }
    
    public void act()
    {
        
    }
   
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}