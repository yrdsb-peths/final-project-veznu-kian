import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends Actor
{
    private int xSpeed = Greenfoot.getRandomNumber(10)-5;
    private int ySpeed = Greenfoot.getRandomNumber(10)-5;
    private int direction = 0;
    
    //Variable to know if game finished 
    private boolean gameEnded = false;
    //Sound used to indicate game is finished 
    GreenfootSound gameOver = new GreenfootSound("sounds/gameOver.mp3");
    
    private boolean motionDirection = true;
    public Ball()
    {
        //set image
        setImage("images/ball.png");
    }
    
    
    public void act()
    {
        moveBall();
        
        checkPlayerBounce();
        checkWallBounce();
        checkGameOver();
        
        
        
    }
    
    private void moveBall()
    {
        
        setLocation(getX() + xSpeed, getY()+ySpeed);
        
    }
    
    private void checkPlayerBounce()
    {
        if(isTouching(PersonOne.class))
        {
            bounce();
        }
        else if(isTouching(PersonTwo.class)) 
        {
            bounce();
        }
        
    }
    
    private void bounce()
    {
        
        
    }
    
    private void checkWallBounce()
    {
        MyWorld world =(MyWorld) getWorld();
        
        if(getY() <= 0)
        {
            ySpeed = ySpeed*-1;
            xSpeed += 1;
        }    
        else if (getY() >= world.getHeight()-1) 
        {
            ySpeed = ySpeed*-1;
            xSpeed += 1;
        }    
        
        
    }
    
   
    
    private void checkGameOver()
    {
        MyWorld world = (MyWorld) getWorld();
        if(getX() <= 0 || getX() >= world.getWidth()-1 && !gameEnded)
        {
            world.gameOver(); 
            gameOver.play();
            gameEnded = true;
            
            
        }
    }
}
