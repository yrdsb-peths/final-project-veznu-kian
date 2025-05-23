import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlockOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonOne extends Actor
{
    /**
     * Act - do whatever the BlockOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    GreenfootImage[] idle = new GreenfootImage[6];
    
    public PersonOne(){
        for(int i = 0; i < idle.length; i++)
        {
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
        }
        setImage(idle[0]);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-10);
        } else if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+10);
        }
        
        collide();
    }
    
    public void collide()
    {
        
        
        
        
        
    }    
}
