
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dog extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation walk;
    public Dog() 
    {
        String[] filenames = new String[10];
        for (int i = 0; i < filenames.length; i++){
            filenames[i] = "img/dog/Walk (" + (i+1) + ").png";
        }
        walk = new Animation(50, filenames);
        walk.scale(300,300);
        walk.setTransparency(20);
        setAnimation(walk);
        
    }
    public void act(){
        super.act();
    }
}
