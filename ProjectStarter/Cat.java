import mayflower.*;

public class Cat extends AnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private int locationX;
    private int locationY;

    public Cat(int x, int y) // the constructor takes two parameters for the x and y location of the character
    {
        locationX = x;
        locationY = y;
        setLocation(locationX, locationY);
    }
    
    public void setWalkRight() //sets the character's animation to walking
    {
        String[] filenames = new String[9];
        for (int i = 0; i < filenames.length; i++){
            filenames[i] = "img/MonkeyAnim/sprite_" + i + ".png";
        }
        walkRight= new Animation(50, filenames);
        walkRight.scale(100,87);
        setAnimation(walkRight);
    }
    public void setWalkLeft() //sets the character's animation to walking
    {
        String[] filenames = new String[9];
        for (int i = 0; i < filenames.length; i++){
            filenames[i] = "img/MonkeyAnim/sprite_" + i + ".png";
            
        }
        walkLeft = new Animation(50, filenames);
        walkLeft.scale(100,87);
        walkLeft.mirrorHorizontally();
        setAnimation(walkLeft);
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
    

    public WorldObject isTouchingObject(){
        if (this.isTouching(Cloud.class)){
            return WorldObject.Cloud;
        }
        if (this.isTouching(Block.class)){
            return WorldObject.Block;
        }
        if (this.isTouching(Banana.class)){
            removeTouching(Banana.class);
            return WorldObject.Banana;
        }
        return null;
    }
   
    
    public void act()
    {
        super.act();
        
    }
}
