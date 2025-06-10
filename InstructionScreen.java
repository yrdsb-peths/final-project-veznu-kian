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
    
    /*
     * This method when called, plays an arcade style soundtrack and checks if the 
     * backspace key is pressed. When the key is pressed it will stop the music and then
     * transition back to the titlescreen
     */
    public void act()
    {
        //Play arcade style music
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
