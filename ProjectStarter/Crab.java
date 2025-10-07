import mayflower.*;
public class Crab extends Actor
{
    private MayflowerImage img;
    private boolean falling;
    public Crab(boolean val){
        img = new MayflowerImage("img/crab.png");
        img.scale(60,40);
        setImage(img);
        falling = val;
    }
    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();   
        
        if (falling) {
            setLocation (x, y-1);
        }
        
    }
}
