import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    
    public Ball()
    {
        setImage("images/ball.png");
    }
    
    public void act()
    {
        int randomNumber = Greenfoot.getRandomNumber(2);
        if(randomNumber == 1)
        {
            setLocation(getX()+2, getY());

        }
        else
        {
            setLocation(getX()-2, getY());
        }        
        
    }
    
    
}
