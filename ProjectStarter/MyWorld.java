import mayflower.*;

public class MyWorld extends World {
    private static int score;
    public static int lives;
    public String[][] tiles;
    public Cat cat;
    private TypeWorld world;
    
    //location of the character
    private int x;
    private int y;
    
    //Default constructor that creates a start screen (black world)
    public MyWorld(String img_file)
    {
        
        setBackground(img_file);

    }
    
    //Constructor to specify an image as the world's background
    public MyWorld(TypeWorld subworld, String img, String[][] array, int x , int y) 
    {
        setBackground(img);
        world = subworld;
        tiles = array; //this used to be String[6][8] 
        //changing it because our worlds require diff sized arrays
        createTiles();
        buildWorld();
        
        this.x = x;
        this.y = y;

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
        addMainCharacter(x, y);
    }

    public void addRandomObjects(){
        
        if(world.equals(TypeWorld.Land)){

            for(int col=0; col<tiles[0].length; col++){
                int rand = (int)(Math.random()*(tiles[0].length));
                if(rand < 10 && tiles[4][col] == ""){
                    tiles[4][col] = "banana";
                }
            }
        }

    }

    public void buildWorld(){
        for(int row=0; row < tiles.length; row++){
            for(int col=0; col < tiles[row].length; col++){
                if(tiles[row][col].equals("ground")){
                    addObject(new Block(false), col * 100, row * 100);
                }
                
            }
        }
    }

    public void addMainCharacter(int x, int y){
        cat = new Cat(x, y);
        boolean added = false;
        while (added == false)
        {
            int row = cat.getX();
            int col = cat.getY();
            
            addObject(cat, row*100, col*100);
            tiles[row][col] = "cat";
            added = true;
            
            
            if (world.equals(TypeWorld.Sky)){
                cat.setIdle();
            }
            else if(world.equals(TypeWorld.Land)){
                cat.setWalkRight();
            }
            else if(world.equals(TypeWorld.Water)){
                cat.setIdle();
            }
        }
    }
    
    public Cat getCat(){
        return cat;
    }
    
    public static void remLife(){
        lives --;
    }
    
    public static void addPoint(){
        score++;
    }

    public void act()
    {
        if(cat.isTouchingObject() == WorldObject.Banana){
            addPoint();
        }        
        showText("Score: " + score, 10, 30, Color.BLACK);
    }
}

