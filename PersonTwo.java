import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Blocks used for pong
 * 
 * @author (Kian) 
 * @version (May 20th 2025)
 */
public class PersonTwo extends Actor
{
    String facing = "left";
    GreenfootImage run = new GreenfootImage("images/Player_run/Run0.png");
    GreenfootImage[] idle = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    public PersonTwo(){
        for(int i = 0; i < idle.length; i++)
        {
           idle[i] = new GreenfootImage("images/Player_run/Run" + i + ".png"); 
           idle[i].mirrorHorizontally();
        }
        animationTimer.mark();
        setImage(idle[0]);
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-10);
        } else if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+10);
        }
        
        animatePersonTwo();
    }
    int imageIndex = 0;
    public void animatePersonTwo()
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
