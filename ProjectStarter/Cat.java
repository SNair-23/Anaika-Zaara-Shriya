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
    
    public int getLocationX()
    {
        return this.locationX * 100; // Convert to pixel value
    }
    public int getLocationY()
    {
        return this.locationY * 100; // Convert to pixel value
    }
    
    public void setFalling()
    {
        this.setLocation(getLocationX(), getLocationY()-1);
    }
    
    public void act()
    {
        super.act();
   
    }
}
