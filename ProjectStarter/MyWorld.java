import mayflower.*;

public class MyWorld extends World {
    private int score;
    private int lives;
    private String[][] tiles;
    private Cat cat;
    private TypeWorld world;

    //Default constructor that creates a start screen (black world)
    public MyWorld()
    {
        setBackground("img/BG/startscreen.png");

    }
    //Constructor to specify an image as the world's background

    //I'm thinking: Each class - sky/land/water can extend MyWorld and call a 
    //reference to this constructor to set the background image as something 
    //different ------ Shriya
    public MyWorld(TypeWorld subworld, String img, String[][] array) 
    {
        setBackground(img);
        world = subworld;
        tiles = array; //this used to be String[6][8] 
        //changing it because our worlds require diff sized arrays
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
        for(int i = 0; i < tiles[tiles.length-1].length; i++)
        {
            tiles[tiles.length-1][i] = "ground";
        }
        addRandomObjects();
        addMainCharacter();
    }

    public void addRandomObjects(){
        if(world.equals(TypeWorld.Sky)){
            for(int row=0; row<tiles.length-1;row++){
                for(int col=0; col<tiles[row].length; col++){
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 2) && tiles[row][col] != "cat"){
                        tiles[row][col] = "banana";
                    }
                }
            }
        }
        else if(world.equals(TypeWorld.Land)){

            for(int col=0; col<tiles[0].length; col++){
                int rand = (int)(Math.random()*(tiles[0].length));
                if(rand < 10 && tiles[5][col] != "cat"){
                    tiles[5][col] = "banana";
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
                if(tiles[row][col].equals("banana")){
                    addObject(new Banana(), col * 100, row * 100);
                }
            }
        }
    }

    public void addMainCharacter(){
        cat = new Cat(4, 3);
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
            if (world.equals(TypeWorld.Sky)){
                cat.setIdle();
            }
            else if(world.equals(TypeWorld.Land)){
                cat.setWalk();
            }
        }
    }

    public void act()
    {
    }
}

