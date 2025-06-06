import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    // Creates label for the name of the game
    GreenfootSound arcademusic = new GreenfootSound("sounds/retro-game-arcade-236133.mp3");
    GreenfootSound mouseClick = new GreenfootSound("sounds/mouse-click-290204.mp3");
    public TitleScreen()
    {    
        super(600, 400, 1); 
        
        // set background
        setBackground("images/introductionScreen.png");
    
    
    }

    public void act()
    {
        arcademusic.play();
        //If space is pressed transition to the instruction screen
        if(Greenfoot.isKeyDown("shift"))
        {
            InstructionScreen instructionScreen = new InstructionScreen();
            Greenfoot.setWorld(instructionScreen);
            arcademusic.stop();
            mouseClick.play();

        }    
        // If space is pressed transition to the option screen
        if(Greenfoot.isKeyDown("space"))
        {
            OptionScreen optionscreen = new OptionScreen();
            Greenfoot.setWorld(optionscreen);
            arcademusic.stop();
            mouseClick.play();

        }    

    }    

    
}
