import mayflower.*;

public class Cat extends AnimatedActor
{
    private Animation walk;
    private Animation idle;
    private int locationX;
    private int locationY;
    public Cat(int x, int y) // the constructor takes two parameters for the x and y location of the character
    {
        locationX = x;
        locationY = y;
        setLocation(locationX, locationY);
    }
    
    public void setWalk() //sets the character's animation to walking
    {
        String[] filenames = new String[9];
        for (int i = 0; i < filenames.length; i++){
            filenames[i] = "img/MonkeyAnim/sprite_" + i + ".png";
        }
        walk = new Animation(50, filenames);
        walk.scale(100,87);
        setAnimation(walk);
    }
    public void setIdle() // sets the character's animation to idle
    {
        String[] filenames1 = new String[2];
        for (int i = 0; i < filenames1.length; i++){
            filenames1[i] = "img/MonkeyAnim/sprite_0.png";
        }
        idle = new Animation(50, filenames1);
        idle.scale(100, 87);
        setAnimation(idle);
    }  
    
    public void act()
    {
        super.act();
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();   
        
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            setLocation (x + 1, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_LEFT )) {
            setLocation(x - 1, y);
            }
    }
}
