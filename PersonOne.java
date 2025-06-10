import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Represents Player One in the game.
 * Handles movement, animation, and size/speed changes.
 * 
 * Player can move up and down using 'w' and 's' keys.
 * The player can be enlarged, shrunk, and have its speed adjusted.
 * 
 */

public class PersonOne extends Actor
{
    /**
     * Act - do whatever the BlockOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Stores the direction the character is facing
    String facing = "right";
    
    // A placeholder image used for animation
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    
    //Array to store animation frames for idle/running
    GreenfootImage[] idle = new GreenfootImage[6];
    GreenfootImage[] originalIdle = new GreenfootImage[6];
    
    // Timer to control animation frame speed
    SimpleTimer animationTimer = new SimpleTimer();
    
    //Speed variable and state
    private boolean isEnlarged = false;
    private int baseSpeed = 10;
    
    //Keeps track of which animation frame is showing
    int imageIndex = 0;
    
    /**
     * Constructor for PersonOne.
     * Loads animation image and timer.
     */
    public PersonOne(){
        for(int i = 0; i < idle.length; i++)
        {
            //Load each frame of the run animation
           GreenfootImage img = new GreenfootImage("images/Player_run/Run" + i + ".png");
           originalIdle[i] = img;
           idle[i] = img;
        }
        animationTimer.mark(); //reset timer
        setImage(idle[0]); // Set the first image initially
        
    }
    
    //Enlarges image by twice it's original size 
    public void enlarge()
    {
        isEnlarged = true;
        
        for (int i = 0; i < idle.length; i++) 
        {
            // change the height 
            GreenfootImage img = new GreenfootImage(originalIdle[i]); // copy original
            img.scale(img.getWidth() * 2, img.getHeight() * 2);
            idle[i] = img;
        }
        
        //Set image
        setImage(idle[imageIndex]);
        
    }
   
    /**
     * Increases the player's speed by 10 units.
     */
    public void changeSpeed()
    {
        baseSpeed = baseSpeed + 10;
    }
    
    /**
     * Resets the player's speed to the default value.
     */
    public void resetSpeed()
    {
        baseSpeed=10;
    }
    
    /**
     * Shrinks the player back to original size by restoring original animation frames.
     */
    public void shrink()
    {
        isEnlarged = false;
        for(int i = 0; i < idle.length; i++)
        {
           idle[i] = originalIdle[i];
           
        }
        setImage(idle[imageIndex]);
    }
    
    public void act()
    {
        movePlayer();
        
    }
    
    /**
     * Moves player up or down based on 'w' and 's' key presses.
     */
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            // Move up
            setLocation(getX(), getY()-baseSpeed);
            animatePersonOne();
        } else if (Greenfoot.isKeyDown("s"))
        {
            //Move down
            setLocation(getX(), getY()+baseSpeed);
            animatePersonOne();
        }
    }
    
    
    /**
     * Animates the player by cycling through frames every 200ms.
     */
    public void animatePersonOne()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            //Dont change image if 200ms hasn't passed
            return;
        }
        animationTimer.mark(); // reset timer
        if (facing.equals("right"))
        {
            //Cycle through the idle animation frames
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }    
}
