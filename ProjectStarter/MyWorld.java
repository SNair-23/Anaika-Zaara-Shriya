import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private Dog dog;
    private Ninja ninja;
    private String[][] tiles;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        tiles = new String[6][8];
        createTiles();
        buildWorld();
        /*/
        cat = new Cat();
        addObject(cat, 100, 100);
        
        dog = new Dog();
        addObject(dog, 200, 100);
        
        ninja = new Ninja();
        addObject(ninja,150, 300);
        */
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