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
    private int actions;
    private Cat skyMonkey;
    private boolean falling;
    private int countFall;
    public SkyWorld()
    {
        // initialise instance variables
        super(TypeWorld.Sky, "img/BG/Sky_Blue.png", new String[30][8], 300, 200);
        skyMonkey = super.getCat();
        actions = 0;
        start = false;
        countFall = 0;
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
                    if(row==1 && col<5){
                        tiles[row][col] = "cloud";

                    }
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 2) && (tiles[row][col] == "")){
                        tiles[row][col] = "cloud";
                    }
                }
         }
    }
    
    @Override
    public void buildWorld(){
        if(countFall == 1){
            super.buildWorld();
        }
        Cloud a = new Cloud(false);
        Cloud b = new Cloud(false);
        addObject(a, 0, 100);
        addObject(b, 100, 100);
        
        for(int row=0; row < tiles.length; row++){
            for(int col=0; col < tiles[row].length; col++){
                if(tiles[row][col].equals("cloud") && countFall == 1){
                    removeObject(a);
                    removeObject(b);
                    addObject(new Cloud(true), col * 100, row * 100);
                }
            }
        }
    }
    
    public int checkIfFalling(int x){
        if(x > 250)
            {
                countFall += 1;
            }
        else
            {
                countFall += 0;
            }
        return countFall;
        }
    
    
    
    public boolean canFall(){
        int counter = 0;
        do{
            if(skyMonkey.getX() > 250 && skyMonkey.getY() < 350){
                counter++;
                return true;
                }
            return false;
        }while(counter == 0);
    }
    
    
    public void act(){
        int x = skyMonkey.getX();
        int y = skyMonkey.getY();
        
        if(checkIfFalling(x) == 1){
            buildWorld();            
        }
        
        
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            skyMonkey.setLocation (x + 1, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_LEFT )) {
            skyMonkey.setLocation(x - 1, y);
            }
        if(isStarted()){
            LandWorld land = new LandWorld();
            Mayflower.setWorld(land);
            start = false;
            //problem? -- will this continue being called and not allow us to
            //move to another world than the sky? -- fix
        }
        if(canFall()){
            skyMonkey.setLocation(x, y + 5); 
        
        }
        while((skyMonkey.isTouchingObject() == WorldObject.Cloud)&&(!Mayflower.isKeyDown(Keyboard.KEY_DOWN))){
                skyMonkey.setLocation(x, y - 5); 
            }
        if(skyMonkey.isTouchingObject() == WorldObject.Block){
                LandWorld land = new LandWorld();
                Mayflower.setWorld(land);
                start = false;
        }
    }
}

