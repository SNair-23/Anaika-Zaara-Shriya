import mayflower.*;
public class Cloud extends Actor
{
    private MayflowerImage img;
    private boolean falling;
    public Cloud(boolean val){
        img = new MayflowerImage("img/cloud.png");
        img.scale(200,87);
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
