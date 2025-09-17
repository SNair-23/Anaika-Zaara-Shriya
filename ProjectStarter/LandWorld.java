
/**
 * Write a description of class LandWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class LandWorld extends MyWorld
{
    
    private boolean start;
    public LandWorld()
    {

        super("img/BG/img.jpg", new String[32][6]);
        
        showText("Replace this bg with a sky image", 200, 200, Color.BLACK);
        
        
    }
    public boolean isStarted(){
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            start = true;
            
        }
        else
        {
            start = false;
        }
        return start;
    } 
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
