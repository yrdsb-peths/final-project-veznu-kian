import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a potion perk in the single-player world.
 * When collected by the ball, it enlarges Player One and plays a sound.
 */
public class Potion extends Actor
{
    // Sound effect played when the potion is collected
    GreenfootSound collectEffect = new GreenfootSound("sounds/collectEffect.mp3");
    
    /**
     * Constructor for Potion.
     * Sets the potion image.
     */
    public Potion()
    {
        //Set image for the potion
        setImage("images/potion.png");
    }
    
    public void act()
    {
        checkCollection();
    }
    
    /**
     * If touching SinglePlayerBall, enlarges Player One and removes potion.
     */
    public void checkCollection()
    {
        if(isTouching(SinglePlayerBall.class)) 
        {
            //Collect potion and enlarges the player 1
            PersonOne player1 = (PersonOne) getWorld().getObjects(PersonOne.class).get(0);
            player1.enlarge();
            collectEffect.play();
            getWorld().removeObject(this);
            
        }
    }
}
