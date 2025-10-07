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
    // instance variables
    private boolean start; //bypass to go to next world without completing
    private Cat skyMonkey; 
    private boolean falling;
    private int countFall;
    private int lives;
    public SkyWorld()
    {
        //create a skyworld and place the monkey on screen
        super(TypeWorld.Sky, "img/BG/Sky_Blue.png", new String[30][8], 300, 200);
        skyMonkey = super.getCat();
        start = false;
        countFall = 0;
        lives = 3;
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
                    if(row<3 && col<5){
                        tiles[row][col] = " ";

                    }
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 1) && (tiles[row][col] == "")){
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
                
                if(tiles[row][col].equals("banana") && countFall == 1){
                    addObject(new Banana(true), col * 100, row * 100);
                }
                
                
            }
        }
    }
    
    public void loseLife(){
         lives -= 1;
         skyMonkey.setLocation(200,200);
    }
    
    public int numLives(){
        return lives;
    }
    
    public int checkIfFalling(int x){
        if(x > 200)
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
        int count = 0;
        while(countFall > 0 && skyMonkey.getY() <500){
            count ++;
            return true;
        }
        
        
        
        return false;
    }
    
    
    public void act(){
        super.act();
        showText("Lives: " + lives, 10, 50, Color.BLACK);

        int x = skyMonkey.getX();
        int y = skyMonkey.getY();
        
        if(checkIfFalling(x) == 1){
            buildWorld();            
        }
        
        if(canFall()){
            skyMonkey.setLocation(x, y + 1); 
        }
        if(y < 0){
            loseLife();
        }
        
        
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            skyMonkey.setWalkRight();
            skyMonkey.setLocation (x + 2, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_LEFT )) {
            skyMonkey.setLocation(x - 2, y);
            skyMonkey.setWalkLeft();

            }
        else{
            skyMonkey.setIdle();
        }
        if(isStarted()){
            LandWorld land = new LandWorld();
            Mayflower.setWorld(land);
            start = false;
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

