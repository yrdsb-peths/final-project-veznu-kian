import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a collectible item which is a :star in the single-player game 
 * mode. When touched by the ball, it increases the player's score,plays a 
 * sound effect, resets ball and player states
 */
public class Star extends Actor
{
    // Sound effect played when star is collected
    GreenfootSound collectEffect = new GreenfootSound("sounds/collectEffect.mp3");

    /**
     * Constructs a Star object and sets its image.
     */
    public Star()
    {
        //set image of actor
        setImage("images/bonuspoint.png");
    }
    
    public void act()
    {
        // Check if touching the ball
        if(isTouching(SinglePlayerBall.class)) 
        {
            
            SinglePlayerWorld world = (SinglePlayerWorld)getWorld();
            SinglePlayerBall ball = (SinglePlayerBall)getOneIntersectingObject(SinglePlayerBall.class);
            PersonOne player = world.getObjects(PersonOne.class).get(0);
            
            //Add score to player 1
            world.player1Score++;
            world.player1Label.setValue(world.player1Score);
            
            //Play sound effect
            collectEffect.play();
            
            //Remove the star from world
            world.removeObject(this);
            
            //Set ball location to the center
            ball.setLocation(world.getWidth()/2, world.getHeight()/2);

                
            //Shrink the player, reset the speed, delay 100 miliseconds
            player.shrink();
            player.resetSpeed();
            Greenfoot.delay(100);
            

            //If player one OR player two reaches the score of 10 then end 
            //the game.
            if (world.player1Score == 10 || world.player2Score == 10)
            {
                world.gameOver();
            }
        }
    }
}
