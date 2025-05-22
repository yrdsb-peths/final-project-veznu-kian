import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends Actor
{
    private int speed = 5;
    private int direction = 0;
    
    public Ball()
    {
        //set image
        setImage("images/ball.png");
    }
    int randomNumber = Greenfoot.getRandomNumber(6);
    boolean justTurned = false;
    public void act()
    {
        movmentPatterns();
        if (isTouching(PersonOne.class))
        {
            if(!justTurned)
            {
                randomNumber = Greenfoot.getRandomNumber(6);
                invMovmentPatterns();
                justTurned = true;
            } else {
                movmentPatterns();
                justTurned = false;
            }
        } else if (isTouching(PersonTwo.class)){
            if(!justTurned)
            {
                randomNumber = Greenfoot.getRandomNumber(6);
                invMovmentPatterns();
                justTurned = true;
            } else {
                movmentPatterns();
                justTurned = false;
            }
            
        }
        
        
    }
    
    private void checkWallBounce()
    {
        MyWorld world =(MyWorld) getWorld();
        
        if(getY() <= 0)
        {
            
        }    
        else if (getY() >= world.getHeight()-1) 
        {
            
        }    
        
        
    }
    
    public void movmentPatterns()
    {
        if(randomNumber == 1)
        {
            setLocation(getX()+1, getY());

        }
        else if(randomNumber == 2)
        {
            setLocation(getX()-1, getY()+3);
        }
        else if(randomNumber == 3)
        {
            setLocation(getX()-1, getY()-3);
        }
        else if(randomNumber == 4)
        {
            setLocation(getX()+1, getY()-3);
        }
        else if(randomNumber == 5)
        {
            setLocation(getX()+1, getY()+3);
        }
        else 
        {
            setLocation(getX()-1, getY());
        }

    }    

    public void invMovmentPatterns()
    {
        if(randomNumber == 1)
        {
            setLocation(getX()-5, getY());

        }
        else if(randomNumber == 2)
        {
            setLocation(getX()+5, getY()-3);
        }
        else if(randomNumber == 3)
        {
            setLocation(getX()+5, getY()+3);
        }
        else if(randomNumber == 4)
        {
            setLocation(getX()-5, getY()+3);
        }
        else if(randomNumber == 5)
        {
            setLocation(getX()-5, getY()-3);
        }
        else 
        {
            setLocation(getX()+5, getY());
        }

    }    
        
}
