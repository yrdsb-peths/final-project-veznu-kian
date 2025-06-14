import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Endworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{

    /**
     * Constructor for objects of class Endworld.
     * 
     */
    public EndWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Set the background color to the game over screen
        setBackground("images/endBackground.png");
        
        
    }
    /*
     * When called, this method checks if the shift key is pressed which transitions the
     * world to the option screen, otherwise when the delete key is pressed it will go 
     * back to the titlescreen world. 
     */
    public void act()
    {
        //Check if the space key is pressed
        if(Greenfoot.isKeyDown("shift"))
        {
            OptionScreen options = new OptionScreen();
            Greenfoot.setWorld(options);
        }
        //Check if delete key is pressed
        if(Greenfoot.isKeyDown("delete"))
        {

            TitleScreen startingScreen = new TitleScreen();
            Greenfoot.setWorld(startingScreen);
         
        }  
    }
}
