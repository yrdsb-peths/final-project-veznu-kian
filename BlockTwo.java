import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Blocks used for pong
 * 
 * @author (Kian) 
 * @version (May 20th 2025)
 */
public class BlockTwo extends Actor
{
    /**
     * Act - do whatever the BlockTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BlockTwo(){
        setImage("images/car02-n.png");
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()+2);
        } else if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()-2);
        }
    }
}
