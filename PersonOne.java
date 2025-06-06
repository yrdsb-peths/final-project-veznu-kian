import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlockOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    //Timer
    private boolean isEnlarged = false;
    
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
    
    //Enlarges image
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
    
    //Shrinks image
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
        if(Greenfoot.isKeyDown("w"))
        {
            // Move up
            setLocation(getX(), getY()-10);
            animatePersonOne();
        } else if (Greenfoot.isKeyDown("s"))
        {
            //Move down
            setLocation(getX(), getY()+10);
            animatePersonOne();
        }
    }
    //Keeps track of which animation frame is showing
    int imageIndex = 0;
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
