import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SinglePlayerBall extends Actor
{
    //Initalizes a speed at the beggining of the game 
    //Starts with either the speed of -3 or 3
    private int xSpeed = Greenfoot.getRandomNumber(6)-3;
    private int ySpeed = Greenfoot.getRandomNumber(6)-3;
        
    //Variable to know if game finished 
    private boolean gameEnded = false;
    
    //Sound used to indicate game is finished 
    GreenfootSound gameOver = new GreenfootSound("sounds/gameOver.mp3");
    
    //Variable that remembers the direction ball is heading toward 
    private boolean movingLeft = true;
  
    
    public SinglePlayerBall()
    {

        //Sets Image
        setImage("images/soccerBall.png");

        //Sets Direction
        setDirection();
    }
    
    //Checks the speed moving horizontally and sets the direction 
    //the ball is heading toward ; Sets direction speed that are zero 
    //to 1
    private void setDirection()
    {
        //If horizontal speed is 0; changes to 1
        if(xSpeed == 0 )
        {
            xSpeed = 1;
        }
        
        //If vertical speed is 0 ; changes to 1
        if(ySpeed == 0 )
        {
            ySpeed = 1;
        }
        
        if(xSpeed > 0 )
        {
            movingLeft = false;
        } 
        else 
        {   
            movingLeft = false;
            
        }
        
    }
    
    public void act()
    {
        moveBall();
        checkPlayerBounce();
        checkWallBounce();
        checkGameOver();
        checkMaxSpeed();
        
        
    }
    
    private void checkMaxSpeed()
    {
        int maxSpeed = 7;
        
        if(xSpeed > 9)
        {
            xSpeed = maxSpeed; 
        }
        
    }
    
    private void moveBall()
    {
        //Moves the Ball according to direction and speed
        setLocation(getX() + xSpeed, getY()+ySpeed);
        
    }
    
    private void checkPlayerBounce()
    {
        //If Ball touches Player : horizontal speed turns negative 
        //making it move in the opposite direction
        if(isTouching(PersonOne.class) || isTouching(PersonTwo.class)||
        isTouching(ComputerPlayer.class))
        {
            xSpeed = xSpeed*-1;
            movingLeft = xSpeed<0;
        }
        
    }
    
    private void bounce()
    {
        //Changes direction of ball : opposite direction 
        ySpeed = ySpeed*-1;
        
        //Speeds up the ball once in contact with wall
        if(movingLeft == true)
        {
            xSpeed -= 1;
        }
        else 
        {
            xSpeed += 1; 
        }
        
        
    }
    
    private void checkWallBounce()
    {
        //Checks if ball touching top or bottom part of the world 
        SinglePlayerWorld world = (SinglePlayerWorld)getWorld();
        
        if(getY() <= 0)
        {
            bounce();
        }    
        else if (getY() >= world.getHeight()-1) 
        {
            bounce();
        }    
        
        
    }
    
   
    
    private void checkGameOver()
    {
        SinglePlayerWorld world = (SinglePlayerWorld) getWorld();
        
        //Checks if ball is touching either side of the world 
        if(getX() <= 0 || getX() >= world.getWidth()-1 && !gameEnded)
        {
            world.gameOver(); 
            gameOver.play();
            gameEnded = true;
            
            
        }
    }
}
