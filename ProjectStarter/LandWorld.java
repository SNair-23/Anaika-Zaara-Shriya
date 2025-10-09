
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
        for(int row = 0; row < tiles.length; row++)
        {
            for (int col = 0; col < tiles[row].length;col++)
            {
                if(tiles[row][col].equals("pig"))
                {
                    int groundY = getGroundYForColumn(col);
                    int pigY = groundY - 40;
                    addObject(new Pig(true), col * 100, pigY);
                }
                if(tiles[row][col].equals("banana")){
                    addObject(new Banana(false), col * 100, row * 100);
                }
            }
        }
    }
    private int getGroundYForColumn(int col)
    {
        for (int row = tiles.length - 1;row >= 0; row--)
        {
            if (tiles[row][col].equals("ground") || tiles[row][col].equals("block"))
            {
                return row * 100;
            }
        }
        return tiles.length * 100;
    }
    private int getGroundY(int x)
    {
        int col = x / 100;
        for (int row = tiles.length - 1; row >= 0; row--)
        {
            if (tiles[row][col].equals("ground") || tiles[row][col].equals("block"))
            {
                return row * 100;
            }
        }
        return tiles.length * 100;
    }
    @Override
    public void addRandomObjects()
    {
        super.addRandomObjects();
        for(int row=0; row<tiles.length-1;row++)
        {
            for(int col=0; col<tiles[row].length; col++)
            {
                int rand = (int)(Math.random()*10);
                if((rand < 1) && tiles[row][col].equals("") && (tiles[row + 1][col].equals("ground")
                || tiles[row + 1][col].equals("block")))
                {
                    tiles[row][col] = "pig";
                }
                
                rand = (int)(Math.random() * 10);
                if((rand < 1) && tiles[row][col].equals("") && (tiles[row + 1][col].equals("ground")
                || tiles[row + 1][col].equals("block")))
                {
                    tiles[row][col] = "banana";
                }
            }
        }
    }
    public void act()
    {

        int x = landMonkey.getX();
        int y = landMonkey.getY();
        
        
        
        if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT )) {
            landMonkey.setWalkRight();
            landMonkey.setLocation (x + 5, y);
        }
        else if (Mayflower.isKeyDown( Keyboard.KEY_LEFT )) {
            landMonkey.setLocation(x - 5, y);
            landMonkey.setWalkLeft();

            }
        else{
            landMonkey.setIdle();
        }
        y = getGroundY(x)- landMonkey.getHeight();
        landMonkey.setLocation(x,y);
        if(isStarted()){
            SeaWorld water = new SeaWorld();
            Mayflower.setWorld(water);
            start = false;
            //problem? -- will this continue being called and not allow us to
            //move to another world than the sky? -- fix
        }
    
    }   
}
