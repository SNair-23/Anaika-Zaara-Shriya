import mayflower.*;
public class Cloud extends Actor
{
    private MayflowerImage img;
    private boolean falling;
    private SkyWorld wo;
    public Cloud(SkyWorld sky, boolean val){
        img = new MayflowerImage("img/cloud.png");
        img.scale(150,87);
        setImage(img);
        falling = val;
        wo = sky;
        
    }
    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();   
        
        if (falling) {
            setLocation (x, y-0.5);
        }
        
        if(y<5){
            wo.removeObject(this); 
        }
        
    }
}
