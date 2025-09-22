import mayflower.*;
public class Banana extends Actor
{
    private MayflowerImage img;
    private boolean falling;
    public Banana(boolean val){
        img = new MayflowerImage("img/banana.png");
        img.scale(100,87);
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
