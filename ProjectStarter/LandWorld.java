
/**
 *
 * @Zaara I (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class LandWorld extends MyWorld
{
    private Cat landMonkey;
    private boolean start;
    
    public LandWorld()
    {

        super(TypeWorld.Land,"img/BG/img.jpg", new String[6][32], 2, 5);
        landMonkey = super.getCat();

        
    }
    public boolean isStarted()
    {
        if (Mayflower.isKeyDown( Keyboard.KEY_W )) {
            start = true;
            
        }
        else
        {
            start = false;
        }
        return start;
    } 
    @Override
    public void buildWorld()
    {
        super.buildWorld();
        Pig a = new Pig(false);
        Pig b = new Pig(false);
        addObject(a, 0, 100);
        addObject(b, 100, 100);
        for(int row = 0; row < tiles.length; row++)
        {
            for (int col = 0; col < tiles[row].length;col++)
            {
                if(tiles[row][col].equals("pig"))
                {
                    addObject(new Pig(true), col * 100, row * 100);
                }
                if(tiles[row][col].equals("banana")){
                    addObject(new Banana(false), col * 100, row * 100);
                }
            }
        }
    }
    
    public void addRandomObjects()
    {
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
                        tiles[row][col] = "pig";

                    }
                    int rand = (int)(Math.random()*(tiles[0].length));
                    if((rand < 2) && (tiles[row][col] == ""))
                    {
                        tiles[row][col] = "pig";
                    }
                }
        }
    }
    
    public void act()
    {
        int x = landMonkey.getX();
        int y = landMonkey.getY();
        
        
        
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            landMonkey.setLocation (x + 1, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_SPACE )) {
            landMonkey.setLocation(x, y + 1);
            }
        if(isStarted()){
            SeaWorld water = new SeaWorld();
            Mayflower.setWorld(water);
            start = false;
            //problem? -- will this continue being called and not allow us to
            //move to another world than the sky? -- fix
        }
    
    }   
}