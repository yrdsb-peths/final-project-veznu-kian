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
        
        // Set the background color to black and fill the screen
        setBackground("images/endBackground.png");
        
        
    }
    
    public void act()
    {
        //Check if the space key is pressed
        if(Greenfoot.isKeyDown("shift"))
        {
            OptionScreen options = new OptionScreen();
            Greenfoot.setWorld(options);
        }
        
        if(Greenfoot.isKeyDown("delete"))
        {

            TitleScreen startingScreen = new TitleScreen();
            Greenfoot.setWorld(startingScreen);
         
        }  
    }
}
