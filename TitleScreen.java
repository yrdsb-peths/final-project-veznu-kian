import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    Label titleLabel = new Label("Hit Ball",50);
    public TitleScreen()
    {    
        super(600, 400, 1); 
        setBackground("images/background_soccer.jpg ");
        addObject(titleLabel, getWidth()/2, getHeight()/2);

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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Press <space> To Continue", 30);
        addObject(label,298,238);
        label.setLocation(312,236);

        
    }
}
