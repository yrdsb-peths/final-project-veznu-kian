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
    
    // Timer to control animation frame speed
    SimpleTimer animationTimer = new SimpleTimer();
    public PersonOne(){
        for(int i = 0; i < idle.length; i++)
        {
            //Load each frame of the run animation
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
        }
        animationTimer.mark(); //reset timer
        setImage(idle[0]); // Set the first image initially
        
    }
    
    public void enlarge()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth()*2;
        int newHeight = image.getHeight()*2;
        image.scale(newWidth,newHeight);
        setImage(image);
        
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
