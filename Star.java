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
            
            SinglePlayerWorld world = (SinglePlayerWorld)getWorld();
            SinglePlayerBall ball = (SinglePlayerBall)getOneIntersectingObject(SinglePlayerBall.class);
            PersonOne player = world.getObjects(PersonOne.class).get(0);
            
            world.player1Score++;
            world.player1Label.setValue(world.player1Score);

            collectEffect.play();
            world.removeObject(this);
            
        
            ball.setLocation(world.getWidth()/2, world.getHeight()/2);

                
        
            player.shrink();
            player.resetSpeed();
            Greenfoot.delay(100);
            


            if (world.player1Score == 10 || world.player2Score == 10)
            {
                world.gameOver();
            }
        }
    }
}
