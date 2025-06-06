import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    
    GreenfootSound arcademusic = new GreenfootSound("sounds/retro-game-arcade-236133.mp3");
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // set the bakground image
        setBackground("images/instructionScreen.png");
    }
    
    public void act()
    {
        arcademusic.play();
        //Check if backspace is pressed
        if(Greenfoot.isKeyDown("backspace"))
        {
            TitleScreen titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
            arcademusic.stop();
         
        }  
    }
    
}
