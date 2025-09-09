
/**
 * Write a description of class Ninja here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ninja extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation walk;
    public Ninja() 
    {
        String[] filenames = new String[10];
        for (int i = 0; i < filenames.length; i++){
            filenames[i] = "img/ninjagirl/Run__00" + (i) + ".png";
        }
        walk = new Animation(50, filenames);
        walk.scale(120, 200);
        walk.setTransparency(40);
        setAnimation(walk);
        
    }
    public void act(){
        super.act();
    }
}
