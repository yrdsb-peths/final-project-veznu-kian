import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlockOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockOne extends Actor
{
    /**
     * Act - do whatever the BlockOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BlockOne(){
        setImage("images/car01-n.png");
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()+2);
        } else if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()-2);
        }
    }
}
