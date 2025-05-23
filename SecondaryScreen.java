import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondaryScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondaryScreen extends World
{
    Label optionOne = new Label("Single Player",30);
    Label optionTwo = new Label("Double Player",30);
    /**
     * Constructor for objects of class SecondaryScreen.
     * 
     */
    
    public SecondaryScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("images/background_soccer.jpg ");

        
        addObject(optionOne, getWidth()/2, getHeight()/2-100);
        addObject(optionTwo, getWidth()/2, getHeight()/2+70);
        
        
        Label optionOne = new Label("Press <s> To Choose Single Player", 20);
        addObject(optionOne,getWidth()/2, getHeight()/2-70);
       
        Label optionTwo = new Label("Press <d> To Choose Double Player", 20);
        addObject(optionTwo,getWidth()/2, getHeight()/2+100);
        
        
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
         
        }  
        
        if(Greenfoot.isKeyDown("d"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
         
        }  
    
    }   
}
