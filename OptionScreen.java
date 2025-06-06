import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondaryScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionScreen extends World
{
    Label optionOne = new Label("Single Player",30);
    Label optionTwo = new Label("Double Player",30);
    GreenfootSound arcademusic = new GreenfootSound("sounds/retro-game-arcade-236133.mp3");
    /**
     * Constructor for objects of class SecondaryScreen.
     * 
     */
    
    public OptionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        setBackground("images/optionScreen.png");
    
        
    }
    
    public void act()
    {
        arcademusic.play();
        
        // Start single player mode if 's' is pressed
        if(Greenfoot.isKeyDown("s"))
        {
            SinglePlayerWorld gameWorld = new SinglePlayerWorld();
            Greenfoot.setWorld(gameWorld);
            arcademusic.stop();
         
        }  
        
        //Start double player mode if 'd' is pressed
        if(Greenfoot.isKeyDown("d"))
        {
            DoublePlayerWorld gameWorld = new DoublePlayerWorld();
            Greenfoot.setWorld(gameWorld);
            arcademusic.stop();
         
        }  
        
    
        if(Greenfoot.isKeyDown("backspace"))
        {
            TitleScreen titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
            arcademusic.stop();
         
        }  
    
    }   
}
