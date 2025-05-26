import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends Actor
{
    //Initalizes a speed at the beggining of the game 
    //Starts with either the speed of 1 or 2 
    private int xSpeed = Greenfoot.getRandomNumber(2)-2;
    private int ySpeed = Greenfoot.getRandomNumber(2)-2;
        
    //Variable to know if game finished 
    private boolean gameEnded = false;
    
    //Sound used to indicate game is finished 
    GreenfootSound gameOver = new GreenfootSound("sounds/gameOver.mp3");
    
    //Variable that remembers the direction ball is heading toward 
    private boolean movingLeft = true;
    private boolean movingUp = true;
    
    public Ball()
    {
        //Sets Image
        setImage("images/ball.png");
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
        
    }
    
    public void act()
    {
        moveBall();
        
        setDirection();
        moveBall();
        checkPlayerBounce();
        checkWallBounce();
        checkGameOver();
        
        
        
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
        if(isTouching(PersonOne.class) || isTouching(PersonTwo.class))
        {
            xSpeed = xSpeed*-1;
        }
        
    }
    
    private void bounce()
    {
        //Changes direction of ball : opposite direction 
        ySpeed = ySpeed*-1;
        
        //Speeds up the ball once in contact with wall
        if(movingLeft == true)
        {
            xSpeed += 2;
        }
        else 
        {
            xSpeed -= 2; 
        }
    }
    
    private void checkWallBounce()
    {
        //Checks if ball touching top or bottom part of the world 
        DoublePlayerWorld world =(DoublePlayerWorld) getWorld();
        
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
        DoublePlayerWorld world = (DoublePlayerWorld) getWorld();
        
        //Checks if ball is touching either side of the world 
        if(getX() <= 0 || getX() >= world.getWidth()-1 && !gameEnded)
        {
            world.gameOver(); 
            gameOver.play();
            gameEnded = true;
            
            
        }
    }
}
