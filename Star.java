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
        //set image of actor
        setImage("images/bonuspoint.png");
    }
    
    public void act()
    {
        // if touching the ball
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
            
            //remove this actor
            world.removeObject(this);
            
            //Set ball location to the middle
            ball.setLocation(world.getWidth()/2, world.getHeight()/2);

                
            //Shrink the player, reset the speed, delay 100 miliseconds
            player.shrink();
            player.resetSpeed();
            Greenfoot.delay(100);
            

            //If player one OR player two reaches the score of 10 then end the game.
            if (world.player1Score == 10 || world.player2Score == 10)
            {
                world.gameOver();
            }
        }
    }
}
