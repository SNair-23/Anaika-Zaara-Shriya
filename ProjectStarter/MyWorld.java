import mayflower.*;

public class MyWorld extends World {
    private int score;
    private int lives;
    private String[][] tiles;
    private Cat cat;
    
    //Default constructor that creates a start screen (black world)
    public MyWorld()
    {
        setBackground("img/BG/startscreen.png");
    }
    //Constructor to specify an image as the world's background
    
    //I'm thinking: Each class - sky/land/water can extend MyWorld and call a 
    //reference to this constructor to set the background image as something 
    //different ------ Shriya
    public MyWorld(String img) 
    {
        setBackground(img);

        tiles = new String[6][8];
        createTiles();
        buildWorld();

        // add objects of worlds (sky, land, ocean), add up scores, 
    }

    public void createTiles(){
        for(int row = 0; row < tiles.length; row++){
            for(int col=0; col < tiles[row].length; col++){
                tiles[row][col] = "";
            }
        }
        for(int i = 0; i < tiles[5].length; i++)
        {
            tiles[5][i] = "ground";
        }
        addRandomObjects();
        addMainCharacter();
    }

    public void addRandomObjects(){
        for(int row=0; row<tiles.length-1;row++){
            for(int col=0; col<tiles[row].length; col++){
                int rand = (int)(Math.random()*(tiles[0].length));
                if(rand < 3){
                    tiles[row][col] = "yarn";
                }
            }
        }
    }

    public void buildWorld(){
        for(int row=0; row < tiles.length; row++){
            for(int col=0; col < tiles[row].length; col++){
                if(tiles[row][col].equals("ground")){
                    addObject(new Block(), col * 100, row * 100);
                }
                if(tiles[row][col].equals("yarn")){
                    addObject(new Yarn(), col * 100, row * 100);
                }
            }
        }
    }

    public void addMainCharacter(){
        cat = new Cat();
        boolean added = false;
        while (added == false)
        {
            int row = (int)(Math.random()*tiles.length);
            int col = (int)(Math.random()*tiles[0].length);
            if(tiles[row][col].equals("")){
                addObject(cat, col, row);
                tiles[row][col] = "cat";
                added = true;
            }
        }
    }

    public void act()
    {
    }

}
