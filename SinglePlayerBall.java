import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the ball in the single-player pong game.
 * Handles movement, bouncing, scoring, and game-over methods
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
    
    //Sound used when ball is kicked 
    GreenfootSound kickSound = new GreenfootSound("sounds/kickSound.mp3");
    
    //Variable that remembers the direction ball is heading toward 
    private boolean movingLeft = true;
  
     /**
     * Constructor to set the ball image and initial direction.
     */
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
            movingLeft = true;
            
        }
        
    }
    
    public void act()
    {
        moveBall();
        checkPlayerBounce();
        checkWallBounce();
        checkMaxSpeed();
        checkEdges();
        checkGameOver();
        updateDirection();
        
    }
    

    /**
     * Updates movingLeft flag based on current xSpeed.
     */

    //Update the direction of the ball
    private void updateDirection()
    {
        if(xSpeed<0)
        {
            movingLeft = true;
        }
        else 
        {
            movingLeft = false;
        }
        
        
    }
    
    /**
     * Limits maximum horizontal speed to 7.
     */
    private void checkMaxSpeed()
    {
        int maxSpeed = 7;
        
        if(xSpeed > 9)
        {
            xSpeed = maxSpeed; 
        }
        
    }
    
    /**
     * Moves the ball based on its current speed.
     */
    private void moveBall()
    {
        //Moves the Ball according to direction and speed
        setLocation(getX() + xSpeed, getY()+ySpeed);
        
    }
    
    /**
     * Reverses horizontal direction and plays sound
     * when ball touches player characters.
     * Decrease computer error when hitting computer player.
     */
    private void checkPlayerBounce()
    {
        //If Ball touches Player : horizontal speed turns negative 
        //making it move in the opposite direction
        if(isTouching(PersonOne.class) || isTouching(PersonTwo.class)||
        isTouching(ComputerPlayer.class))
        {
            xSpeed = xSpeed*-1;
            kickSound.play();
            
            if(isTouching(ComputerPlayer.class))
            {
                ComputerPlayer.computerError--;
            }
        }
        
    }
    
    /**
     * Reverses vertical direction and slightly speeds up horizontal speed
     * when the ball bounces off the top or bottom wall.
     */
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
    
    /**
     * Checks for collision with top or bottom of world, and bounces while.
     * increasing computer error when bouncing on walls.
     */
    private void checkWallBounce()
    {
        //Checks if ball touching top or bottom part of the world 
        SinglePlayerWorld world = (SinglePlayerWorld)getWorld();
        
        if(getY() <= 0)
        {
            bounce();
            ComputerPlayer.computerError+=10;
        }
            
        else if (getY() >= world.getHeight()-1) 
        {
            bounce();
            ComputerPlayer.computerError+=10;
        }    
        
        
    }
    
     /**
     * Checks if ball has reached left or right edges,
     * updates scores and resets the ball.
     */
    private void checkEdges() {
        if (getX() <= 0) {
            // Player 2 scores
            SinglePlayerWorld world = (SinglePlayerWorld)getWorld();
            ComputerPlayer.computerError = 0;
            world.addScoreToPlayer2();
            resetBall();
          
        } else if (getX() >= getWorld().getWidth() - 1) {
            // Player 1 scores
            SinglePlayerWorld world = (SinglePlayerWorld)getWorld();
            world.addScoreToPlayer1();
            ComputerPlayer.computerError = 0;
            resetBall();
        }
    }
    
    /**
     * Resets the ball to the center of the game world.
     * Also shrinks and resets speed of the player one character,
     * then delays to give players a moment before continuing to play.
     */
    private void resetBall() {
        setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        SinglePlayerWorld  world = (SinglePlayerWorld) getWorld();
        PersonOne player1 = world.getObjects(PersonOne.class).get(0);
        player1.shrink();
        player1.resetSpeed();
        
        Greenfoot.delay(100);
    }
    
    /**
     * Checks if the game has ended by seeing if either player has reached
     * the winning score. If the game is over, it will change the world
     * and plays the game over sound.
     */
    private void checkGameOver()
    {
        SinglePlayerWorld world = (SinglePlayerWorld) getWorld();
        
        int p1Score = world.player1Score;
        int p2Score = world.player2Score;
        //Checks if ball is touching either side of the world 
        if(p1Score == 10 || p2Score == 10)
        {
            world.gameOver(); 
            gameOver.play();
            gameEnded = true;
            
            
        }
    }
}
