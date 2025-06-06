import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound collectEffect = new GreenfootSound("sounds/collectEffect.mp3");

    public Star()
    {
        setImage("images/bonuspoint.png");
    }
    
    public void act()
    {
        if(isTouching(SinglePlayerBall.class)) 
        {
            
            
            collectEffect.play();
            
            getWorld().removeObject(this);
            
        }
    }
}
