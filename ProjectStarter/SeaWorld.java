import mayflower.*;
public class SeaWorld extends MyWorld {
    private boolean levelComplete;
    private Cat seaMonkey;

    public SeaWorld() {
        super(TypeWorld.Water, "img/BG/SeaWorld.png", new String[30][8], 600, 800);
        levelComplete = false;
        seaMonkey = super.getCat();
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

    public void act(){
        int x = seaMonkey.getX();
        int y = seaMonkey.getY();

        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            seaMonkey.setLocation (x + 1, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_SPACE )) {
            seaMonkey.setLocation(x, y + 1);
        }
        if(isStarted()){
            SeaWorld water = new SeaWorld();
            Mayflower.setWorld(water);
            levelComplete = false;
        }
    }
}
