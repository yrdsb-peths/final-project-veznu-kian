import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer extends Actor
{
    /**
     * Act - do whatever the BlockOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String facing = "left";
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    GreenfootImage[] idle = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    
    private SinglePlayerBall gameBall;
    
    public ComputerPlayer(SinglePlayerBall ball){
        for(int i = 0; i < idle.length; i++)
        {
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
           idle[i].mirrorHorizontally();
        }
        animationTimer.mark();
        setImage(idle[0]);
        gameBall = ball;
        
    }
    
    public void act()
    {
        int ballY = gameBall.getY();
        int randomDiffrence = Greenfoot.getRandomNumber(10)-5;
        
        setLocation(getX(), ballY+randomDiffrence); 
        
        animatePersonOne();
    }
    
    int imageIndex = 0;
    public void animatePersonOne()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        if (facing.equals("left"))
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }    
}

