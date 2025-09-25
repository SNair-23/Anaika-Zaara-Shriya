/**
 * SkyWorld is a class that creates a world with the background of a sky.
 * It will have the actor falling through the sky and dodging obstacles.
 * Once the player reaches the bottom of the skyworld, the world is changed to 
 * LandWorld
 * 
 * ---As of now, the cat needs to be deleted, the bg changed, and the animation running
 * Q: does the actor falling through this world have to be written in the actor's class?
 * or can we just write it in these world classes.
 * 
 * @Shriya N
 * @version1
 */
import mayflower.*;
public class SkyWorld extends MyWorld
{
    // instance variables - replace the example below with your own
    private boolean start;
    private int bottomRow;
    private Cat skyMonkey;
    public SkyWorld()
    {
        // initialise instance variables
        super(TypeWorld.Sky, "img/BG/Sky_Blue.png", new String[30][8], 300, 200);
        start = false;
        bottomRow = 6;
        skyMonkey = super.getCat();
    }
    
    public boolean isStarted(){
        if (Mayflower.isKeyDown(Keyboard.KEY_D)) {
            start = true;

        }
        else{
            start = false;
        }
        return start;
    }
    
    @Override
    public void addRandomObjects(){
        for(int row=0; row<tiles.length-1;row++){
                for(int col=0; col<tiles[row].length; col++){
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 1) && tiles[row][col] == ""){
                        tiles[row][col] = "banana";
                    }
                }
            }
        for(int row=1; row<tiles.length-1;row++){
                for(int col=0; col<tiles[row].length; col++){
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 3) && (tiles[row][col] == "")){
                        tiles[row][col] = "cloud";
                    }
                }
         }
    }
    
    @Override
    public void buildWorld(){
        super.buildWorld();
        for(int row=0; row < tiles.length; row++){
            for(int col=0; col < tiles[row].length; col++){
                if(tiles[row][col].equals("cloud")){
                    addObject(new Cloud(true), col * 100, row * 100);
                }
            }
        }
    }
    
    public void scroll(){
        while (bottomRow != 30){
            bottomRow ++;

        }
    }
     public boolean isBlocked(){
        if(skyMonkey.isTouchingCloud()){
            return true;
        }
        return false;
    }
    
    
    
    public void act(){
        if(isStarted()){
            LandWorld land = new LandWorld();
            Mayflower.setWorld(land);
            start = false;
            //problem? -- will this continue being called and not allow us to
            //move to another world than the sky? -- fix
        }
        while(isBlocked()){
            skyMonkey.setLocation(skyMonkey.getX(), skyMonkey.getY() - 4); 
        }
        skyMonkey.setLocation(skyMonkey.getX(), skyMonkey.getY() + 5); 
    }
}

