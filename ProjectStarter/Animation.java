
/**
 * Write a description of class Animation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class Animation
{
    // instance variables - replace the example below with your own
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;

    /**
     * Constructor for objects of class Animation
     */
    public Animation(int frameRate, String[] filenames)
    {
        // initialise instance variables
        frames = new MayflowerImage[filenames.length];
        for(int i = 0; i < filenames.length; i++){
            frames[i] = new MayflowerImage(filenames[i]);
        }
        this.framerate = frameRate;
        this.currentFrame = 0;

    }

    public int getFrameRate()
    {
        return this.framerate;
    }

    public MayflowerImage getNextFrame()
    {
        currentFrame ++;
        if(currentFrame == frames.length){
            currentFrame = 0;
        }

        return frames[currentFrame];
    }
    
    public void scale(int w, int h){
        for(int image = 0; image < frames.length; image++){
            frames[image].scale(w,h);
        }
    }
    
    public void setTransparency(int percent){
        for(int image = 0; image < frames.length; image++){
            frames[image].setTransparency(percent);
        }
    }
}
