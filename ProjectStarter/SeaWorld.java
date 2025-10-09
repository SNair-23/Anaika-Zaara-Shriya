import mayflower.*;
public class SeaWorld extends MyWorld {
    private boolean didWin;
    private boolean didLose;
    private Cat seaMonkey;
    private boolean start;
    private int lives;
    public SeaWorld() {
        super(TypeWorld.Water, "img/BG/SeaBlue.jpg", new String[30][8], 600, 800);
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
                if (tiles[row][col].equals("crab")) {
                    addObject(new Crab(false), col * 100, row * 100);
                }
                if(tiles[row][col].equals("banana")){
                    addObject(new Banana(false), col * 100, row * 100);
                }
                addObject(new Portal(false), 700, 500);
            }
        }
    
    }
    
    public void loseLife(){
         lives -= 1;
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
        showText("Lives: " + lives, 10, 50, Color.BLACK);
        int x = seaMonkey.getX();
        int y = seaMonkey.getY();
        int w = getWidth();
        int h = getHeight();
        
        if(seaMonkey.isTouchingObject() == WorldObject.Crab)
        {
            loseLife();
        }
       
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x+w<800)
        {
            seaMonkey.setLocation(x+1, y);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x>0)
        {
            seaMonkey.setLocation(x-1, y);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y>0)
        {
            seaMonkey.setLocation(x, y-1);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y<600)
        {
            seaMonkey.setLocation(x, y+1);
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
