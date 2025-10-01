
/**
 *
 * @Zaara I (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class LandWorld extends MyWorld
{
    
    private boolean start;
    public LandWorld()
    {

        super(TypeWorld.Land,"img/BG/img.jpg", new String[6][32], 2, 5);
        
        
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
    public void buildWorld()
    {
        super.buildWorld();
        for(int row = 0; row < tiles.length; row++)
        {
            for (int col = 0; col < tiles[row].length;col++)
            {
                if(tiles[row][col].equals("cloud"))
                {
                    addObject(new Cloud(true), col * 100, row * 100);
                }
            }
        }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    }
}
