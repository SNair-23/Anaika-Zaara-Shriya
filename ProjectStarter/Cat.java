import mayflower.*;

public class Cat extends AnimatedActor
{
    private Animation walk;
    public Cat() 
    {
        String[] filenames = new String[10];
        for (int i = 0; i < filenames.length; i++){
            filenames[i] = "img/cat/Walk (" + (i+1) + ").png";
        }
        walk = new Animation(50, filenames);
        walk.scale(100,87);
        //walk.setTransparency(50);
        setAnimation(walk);
        
    }
    public void act()
    {
        super.act();
    }
}
