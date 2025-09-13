import mayflower.*;
public class Banana extends Actor
{
    private MayflowerImage img;
    public Banana(){
        img = new MayflowerImage("img/banana.png");
        img.scale(100,87);
        setImage(img);
    }
    public void act(){
    
    }
}
