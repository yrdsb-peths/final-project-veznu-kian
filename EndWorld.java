import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Endworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    Label titleLabel = new Label("Press <Space> for next round",50);
    
    /**
     * Constructor for objects of class Endworld.
     * 
     */
    public EndWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        addObject(titleLabel, getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        
        if(Greenfoot.isKeyDown("space"))
        {
            DoublePlayerWorld gameWorld = new DoublePlayerWorld();
            Greenfoot.setWorld(gameWorld);
         
        }  
    }
}
