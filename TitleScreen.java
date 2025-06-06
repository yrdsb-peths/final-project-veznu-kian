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
  
    public TitleScreen()
    {    
        super(600, 400, 1); 
        
        // set background
        setBackground("images/introductionScreen.png");
    
    
    }

    public void act()
    {
        //If space is pressed transition to the instruction screen
        if(Greenfoot.isKeyDown("shift"))
        {
            InstructionScreen instructionScreen = new InstructionScreen();
            Greenfoot.setWorld(instructionScreen);

        }    
        
        if(Greenfoot.isKeyDown("space"))
        {
            OptionScreen optionscreen = new OptionScreen();
            Greenfoot.setWorld(optionscreen);

        }    

    }    

    
}
