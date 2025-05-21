import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends Actor
{
    int randomNumber = Greenfoot.getRandomNumber(6);
    public Ball()
    {
        setImage("images/ball.png");
    }
    
    public void act()
    {
        
        if(randomNumber == 1)
        {
            setLocation(getX()+2, getY());

        }
        else if(randomNumber == 2)
        {
            setLocation(getX()-2, getY()+2);
        }
        else if(randomNumber == 3)
        {
            setLocation(getX()-2, getY()-2);
        }
        else if(randomNumber == 4)
        {
            setLocation(getX()+2, getY()-2);
        }
        else if(randomNumber == 5)
        {
            setLocation(getX()+2, getY()+2);
        }
        else 
        {
            setLocation(getX()-2, getY());
        }
        
    }
    
    
}
