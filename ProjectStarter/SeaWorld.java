import mayflower.*;

public class SeaWorld extends MyWorld {
    private boolean levelComplete;
    private boolean start;

    public SeaWorld() {
        super(TypeWorld.Sea, "img/BG/Sea_Blue.png", new String[30][8], 300, 200);
        levelComplete = false;
    }
    
    public boolean isStarted(){
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            start = true;
            
        }
        else
        {
            start = false;
        }
        return start;
    } 

    @Override
    public void addRandomObjects() {
        super.addRandomObjects();
        for (int row = 1; row < tiles.length - 1; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                int rand = (int) (Math.random() * tiles[0].length);
                if (rand < 3 && tiles[row][col].equals("")) {
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
                    addObject(new Crab(true), col * 100, row * 100);
                }
            }
        }
    }

    @Override
    public void act() {
        // Check if the monkey reaches the "end" of the level
        Actor monkey = getFirstMonkey();

        if (monkey != null && hasReachedEnd(monkey)) {
            levelComplete = true;
        }

        /*
         * if (levelComplete) {
            Mayflower.setWorld(new GameOverWorld());
       
        }
        */
    }

    // get the player (monkey) actor
    private Actor getFirstMonkey() {
        if (getObjects(Cat.class).size() > 0) {
            return getObjects(Cat.class).get(0);
        }
        return null;
    }

    // check if monkey reached right edge (or final tile)
    private boolean hasReachedEnd(Actor monkey) {
        return monkey.getX() + monkey.getWidth() >= getWidth() - 10;
    }
}

