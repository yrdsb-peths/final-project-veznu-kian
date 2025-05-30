import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{

    Label title = new Label ("Instructions", 50);
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/background_soccer.jpg ");
        addObject(title, getWidth()/2, 50);
        
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            OptionScreen optionScreen = new OptionScreen();
            Greenfoot.setWorld(optionScreen);

        }    
    }
    
    private void prepare()
    {
        Label playerOne = new Label ("Player one: Use 'W' and 'S'", 30);
        Label playerTwo = new Label ("Player two: Use '↑' and '↓'", 30);
        Label single = new Label ("When single player is selected, you are assigned as player one", 25);
        
        addObject(single, getWidth()/2, 200);
        addObject(playerOne, getWidth()/2, 150);
        addObject(playerTwo, getWidth()/2, 250);
        
        Label label = new Label("Press <space> To Continue", 30);
        addObject(label,298,238);
        label.setLocation(getWidth()/2 ,350);
    }
}
