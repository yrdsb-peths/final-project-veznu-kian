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
    Label titleLabel = new Label("Hit Ball",50);
    public TitleScreen()
    {    
        super(600, 400, 1); 
        
        // set background
        setBackground("images/background_soccer.jpg ");
        
        // Adds the name of the game to the screen
        addObject(titleLabel, getWidth()/2, getHeight()/2);

        //Call the method below
        prepare();
        
    
    }

    public void act()
    {
        //If space is pressed transition to the instruction screen
        if(Greenfoot.isKeyDown("space"))
        {
            InstructionScreen instructionScreen = new InstructionScreen();
            Greenfoot.setWorld(instructionScreen);

        }    

    }    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Create label that tells the player what to press to move onto the next screen
        Label label = new Label("Press <space> To Continue", 30);
        addObject(label,298,238);
        label.setLocation(312,236);

        
    }
}
