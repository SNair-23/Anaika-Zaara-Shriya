import mayflower.*;
public class SeaWorld extends MyWorld {
    private boolean levelComplete;
    private Cat seaMonkey;
    private int lives;
    public SeaWorld() {
        super(TypeWorld.Water, "img/BG/SeaBlue.jpg", new String[30][8], 600, 800);
        levelComplete = false;
        seaMonkey = super.getCat();
        lives = 3;
    }

    public boolean isStarted(){
        if (Mayflower.isKeyDown(Keyboard.KEY_D)) {
            levelComplete = true;

        }
        else 
        {
            levelComplete = false;
        }

        return levelComplete;
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
        for (int row = 1; row < tiles.length - 1; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                int rand = (int)(Math.random() * tiles[0].length);
                if (rand < 3 && tiles[row][col].equals("")) {
                    tiles[row][col] = "crab";  // spawn crab enemies
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
            }
        }
    }
    
    public void loseLife(){
         lives -= 1;
    }
    
    public int numLives(){
        return lives;
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
            seaMonkey.setLocation(x-1, y);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x>0)
        {
            seaMonkey.setLocation(x+1, y);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y>0)
        {
            seaMonkey.setLocation(x, y-1);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y<600)
        {
            seaMonkey.setLocation(x, y+1);
        }
        
        if(isStarted()){
            SeaWorld water = new SeaWorld();
            Mayflower.setWorld(water);
            levelComplete = false;
        }
    }
}
