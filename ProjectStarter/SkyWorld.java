/**
 * SkyWorld is a class that creates a world with the background of a sky.
 * It will have the actor falling through the sky and dodging obstacles.
 * Once the player reaches the bottom of the skyworld, the world is changed to 
 * LandWorld. 
 * 
 * ---As of now, the cat needs to be deleted, the bg changed, and the animation running
 * Q: does the actor falling through this world have to be written in the actor's class?
 * or can we just write it in these world classes.
 * 
 * @Shriya N
 * @version1
 */
import mayflower.*;
public class SkyWorld extends MyWorld
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SkyWorld
     */
    public SkyWorld()
    {
        // initialise instance variables
        super("img/BG/BG.png");
        showText("Replace this bg with a sky image", 200, 200, Color.BLACK);
        
    }


}