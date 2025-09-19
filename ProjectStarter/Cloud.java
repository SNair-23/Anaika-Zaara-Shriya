import mayflower.*;
public class Cloud extends Actor
{
    private MayflowerImage img;
    public Cloud(){
        img = new MayflowerImage("img/cloud.png");
        img.scale(200,87);
        setImage(img);
    }
    public void act(){
    
    }
}
