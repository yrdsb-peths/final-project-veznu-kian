import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Endworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    //label to tell player what keybind to press to restart the game
    Label titleLabel = new Label("Press <Space> To Restart Game",50);
    
    /**
     * Constructor for objects of class Endworld.
     * 
     */
    public EndWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Set the background color to black and fill the screen
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        //Add the restart prompt label to the center of the screen
        addObject(titleLabel, getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        //Check if the space key is pressed
        if(Greenfoot.isKeyDown("space"))
        {

            TitleScreen startingScreen = new TitleScreen();
            Greenfoot.setWorld(startingScreen);
            // Create and switch to a new instance of the game world
            SinglePlayerWorld gameWorld = new SinglePlayerWorld();
            Greenfoot.setWorld(gameWorld);

         
        }  
    }
}
