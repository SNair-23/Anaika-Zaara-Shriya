
/**
 * This class creates the starting screen of our game!
 * It has a constructor, which creates a plain black world with a reference
 * to the default constructor of MyWorld - and writes welcome text to the screen
 * 
 * It also contains a getter method which checks if the user has pressed the Right
 * arrow key to start the game. This method is called in the overridden act() 
 * method to make sure it repeatedly checks if the used has pressed the button yet.
 * 
 * @Shriya N
 * @version 1
 */
import mayflower.*;
public class StarterScreen extends MyWorld
{
    // instance variables - replace the example below with your own
    private String text;
    private boolean start;
    private MayflowerImage startbutton;
    
    public StarterScreen()
    {
        // initialise instance variables
        super("img/BG/startscreen.png");
        text = "Welcome to our game!";
        showText(this.text, 200, 100, Color.WHITE);
        showText("Click Right Arrow Key to begin >", 20, 100, 180, Color.BLUE); 
        
        //optional starter button for graphics
        startbutton = new MayflowerImage("img/Object/Sign_2.png");
    }
    
    public boolean isStarted(){
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            start = true;
            
        }
        else{
            start = false;
        }
        return start;
    }
    
    @Override
    public void act(){
        if(isStarted()){
            SkyWorld sky = new SkyWorld();
            Mayflower.setWorld(sky);
            //problem? -- will this continue being called and not allow us to
            //move to another world than the sky? -- fix
        }
    }
}
