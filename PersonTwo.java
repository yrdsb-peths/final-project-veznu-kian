import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents Player Two in the game.
 * Handles vertical movement and animation.
 * Player moves up and down with the arrow keys.
 * The player faces left, so animation frames are mirrored.
 */
public class PersonTwo extends Actor
{
    //Stores the direction the character is facing
    String facing = "left";
    
    // A placeholder image used for animation
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    
    // Array to store animation frames for idle / running
    GreenfootImage[] idle = new GreenfootImage[6];
    
    // Timer to control animation frame speed
    SimpleTimer animationTimer = new SimpleTimer();

    //Keeps track of which animation frame is showing
    int imageIndex = 0;
    
    /**
     * Constructor for PersonTwo.
     * Loads and mirrors animation frames, sets initial image and timer.
     */
    public PersonTwo(){
        
        for(int i = 0; i < idle.length; i++)
        {
            //Load each frame of the run animation
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
           idle[i].mirrorHorizontally();
        }
        animationTimer.mark(); // reset timer
        setImage(idle[0]); // Set the first image initially
        
    }
    

    public void act()
    {
        movePlayer();
        
    }
    
    /**
     * Moves player up or down based on arrow key inputs.
     * Animates player while moving.
     */
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            // move up
            setLocation(getX(), getY()-10);
            animatePersonTwo();
        } else if (Greenfoot.isKeyDown("down"))
        {
            // move down
            setLocation(getX(), getY()+10);
            animatePersonTwo();
        }
        
    }
    
    /**
     * Animates the player by cycling through mirrored frames every 200 milliseconds.
     */
    public void animatePersonTwo()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            // Don't change image if 200ms hasn't passed
            return;
        }
        animationTimer.mark();
        if (facing.equals("left"))
        {
            // Cycle through the idle animation frames
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }    
}
