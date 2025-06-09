import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a collectible object in the game.
 * When the ball touches the banana, it triggers a speed change for Player One,
 * plays a collection sound effect, and then removes itself from the world. If 
 * not collected by the end of the round, it will remove itself and spawn 
 * in a new location.
 */
public class Banana extends Actor
{
    // Sound effect played when the banana is collected
    GreenfootSound collectEffect = new GreenfootSound("sounds/collectEffect.mp3");
    
    /**
     * Constructor for Banana.
     * Sets the initial image of the banana.
     */
    public Banana()
    {
        setImage("images/banana.png");
    }
    
    /**
     * Checks if the banana has been collected.
     */
    public void act()
    {
        checkCollection();
    }
    
    /**
     * Checks if the banana is touching the game ball.
     * If so, it increases Player One's speed, plays the collection sound,
     * and removes the banana from the world.
     */
    public void checkCollection()
    {
        if(isTouching(SinglePlayerBall.class)) 
        {
            //Access the first PlayerOne object
            PersonOne player1 = (PersonOne) getWorld().getObjects(PersonOne.class).get(0);
            
            //Changes speed of PlayerOne 
            player1.changeSpeed();
            
            //Play the sound effect 
            collectEffect.play();
            
            //Remove banana from class
            getWorld().removeObject(this);
            
        }
        
    }
}
