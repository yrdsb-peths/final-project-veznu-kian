import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer extends Actor
{
    //Direction the character is facing
    String facing = "left";
    //default image when not animating
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    //array to hold the idle animation frames
    GreenfootImage[] idle = new GreenfootImage[6];
    //timer to control animation speed
    SimpleTimer animationTimer = new SimpleTimer();
    
    //Reference to game ball to track its position
    private SinglePlayerBall gameBall;
    
    public ComputerPlayer(SinglePlayerBall ball){
        //Load and mirror the idle animation images
        for(int i = 0; i < idle.length; i++)
        {
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
           idle[i].mirrorHorizontally();
        }
        //Start the animation timer and set the initial image
        animationTimer.mark();
        setImage(idle[0]);
        // Store the reference to the ball to follow its movement
        gameBall = ball;
        
    }
    
    public void act()
    {
        // moves the ai player and animates its movement
        followBall();
        animatePersonOne();
    }
    
    public void followBall()
    {
        //causes 'computer' to follow the vertical position of the ball
        int ballY = gameBall.getY();
        setLocation(getX(), ballY);
        
    }
    
    //index used to loop through animation frames
    int imageIndex = 0;
    public void animatePersonOne()
    {
        // Only update the fram if at least 200 milliseconds have passed
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        //Cycle through the irrored running frames
        if (facing.equals("left"))
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }    
}

