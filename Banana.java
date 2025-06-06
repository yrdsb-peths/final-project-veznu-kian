import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Actor
{
    /**
     * Act - do whatever the Banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Banana()
    {
        setImage("images/banana.png");
    }
    
    public void act()
    {
        checkCollection();
    }
    
    GreenfootSound collectEffect = new GreenfootSound("sounds/collectEffect.mp3");
    public void checkCollection()
    {
        if(isTouching(SinglePlayerBall.class)) 
        {
            //Collect potion and enlarges the player 1
            PersonOne player1 = (PersonOne) getWorld().getObjects(PersonOne.class).get(0);
            player1.changeSpeed();
            collectEffect.play();
            getWorld().removeObject(this);
            
        }
        
    }
}
