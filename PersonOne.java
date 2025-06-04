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
    String facing = "right";
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    GreenfootImage[] idle = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    public PersonOne(){
        for(int i = 0; i < idle.length; i++)
        {
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
        }
        animationTimer.mark();
        setImage(idle[0]);
        
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
            setLocation(getX(), getY()-10);
            animatePersonOne();
        } else if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+10);
            animatePersonOne();
        }
    }
    int imageIndex = 0;
    public void animatePersonOne()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        if (facing.equals("right"))
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }    
}
