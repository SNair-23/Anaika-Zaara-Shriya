import mayflower.*;
public class SeaWorld extends MyWorld {
    public static boolean didWin;
    private boolean didLose;
    private Cat seaMonkey;
    private boolean start;
    public static int lives;
    public SeaWorld() {
        super(TypeWorld.Water, "img/BG/ocean.png", new String[30][8], 600, 800);
        didWin = false;
        didLose = false;
        seaMonkey = super.getCat();
        lives = 5;
    }

    public boolean goToWin(){
        if (gameWin()) {
            didWin = true;

        }
        else 
        {
            didWin = false;
        }

        return didWin;
    }
    
    public boolean goToLose(){
        if (gameLose()) {
            didLose = true;

        }
        else 
        {
            didLose = false;
        }

        return didLose;
    }

    @Override
    public void addRandomObjects() {
        super.addRandomObjects();
        // Add bananas randomly
        for(int row=0; row<tiles.length-1;row++)
        {
                for(int col=0; col<tiles[row].length; col++)
                {
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 1) && tiles[row][col] == "")
                    {
                        tiles[row][col] = "banana";
                    }
                }
        }
        // Add crabs randomly
        for(int row=1; row<tiles.length-1;row++)
        {
                for(int col=0; col<tiles[row].length; col++)
                {
                    if(row==1 && col>5)
                    {
                        tiles[row][col] = "crab";

                    }
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 2) && (tiles[row][col] == ""))
                    {
                        tiles[row][col] = "crab";
                    }
                }
        }
    }

    @Override
    public void buildWorld() {
        super.buildWorld();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                if (tiles[row][col].equals("crab")&&!tiles[row][col].equals("banana")&&!tiles[row][col].equals("portal")) {
                    addObject(new Crab(false), col * 100, row * 100);
                }
                if(tiles[row][col].equals("banana")&&!tiles[row][col].equals("crab")&&!tiles[row][col].equals("portal")){
                    addObject(new Banana(false), col * 100, row * 100);
                }
                // One fixed portal in bottom-right corner
                addObject(new Portal(false), 700, 500);
            }
        }
    
    }
    
    public void loseLife(){
         lives--;
    }
    
    public int numLives(){
        return lives;
    }
    
    public boolean gameWin()
    {
        if(seaMonkey.isTouchingObject() == WorldObject.Portal)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean gameLose()
    {
        if(lives == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    public void act(){
        super.act();
        showText("Lives: " + lives, 10, 55, Color.BLACK);
        
        int x = seaMonkey.getX();
        int y = seaMonkey.getY();
        
        if (seaMonkey.isTouchingObject() == WorldObject.Banana) {
            addPoint();
        }
       
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            seaMonkey.setWalkRight();
            seaMonkey.setLocation (x + 5, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_LEFT )) {
            seaMonkey.setLocation(x - 5, y);
            seaMonkey.setWalkLeft();

            }
        else if (Mayflower.isKeyDown( Keyboard.KEY_UP )&& y>0) {
            seaMonkey.setLocation(x, y-5);
            seaMonkey.setIdle();

            }
        else if (Mayflower.isKeyDown( Keyboard.KEY_DOWN)&& y<600) {
            seaMonkey.setLocation(x, y+5);
            seaMonkey.setIdle();

            }
        else{
            seaMonkey.setIdle();
        }
        
        if(goToWin()){
            EndWinScreen win = new EndWinScreen();
            Mayflower.setWorld(win);
            didWin = false;
        }
        
        if(goToLose()){
            EndLoseScreen lose = new EndLoseScreen();
            Mayflower.setWorld(lose);
            didLose = false;
        }
    }
}
