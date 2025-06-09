import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * Represents the ball used in the Double Player game mode.
  * 
  * The ball moves across the screen, bouncing off players and walls.
  * It tracks scoring and checks if game is finished 
  */
public class DoublePlayerBall extends Actor
{
    //Initalizes a speed at the beggining of the game 
    //Starts with either the speed of -3 or 3
    private int xSpeed = Greenfoot.getRandomNumber(6)-3;
    private int ySpeed = Greenfoot.getRandomNumber(6)-3;
        
    //Variable to know if game finished 
    private boolean gameEnded = false;
    
    //Sound used to indicate game is finished 
    GreenfootSound gameOver = new GreenfootSound("sounds/game-over-deep-male-voice-clip-352695.mp3");
    
    //Sound used to indicate round is over 
    GreenfootSound roundOver = new GreenfootSound("sounds/gameOver.mp3");
    
    //Sound used when ball is kicked 
    GreenfootSound kickSound = new GreenfootSound("sounds/kickSound.mp3");
    
    //Sound used when round starts 
    GreenfootSound roundStart = new GreenfootSound("sounds/game-start-6104.mp3");
    
    //Variable that remembers the direction ball is heading toward 
    private boolean movingLeft = true;
  
    /**
     * Constructor for the DoublePlayerBall.
     * Sets initial image and direction.
     */
    public DoublePlayerBall()
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
        
        if(xSpeed < 0 )
        {
            movingLeft = true;
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
        checkMaxSpeed();
        checkEdges();
        checkGameOver();
        updateDirection();
        
    }
     
    /**
     * Updates the movingLeft variable based on current horizontal speed.
     */
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
     * Limits the horizontal speed to a maximum value to prevent the ball from going too fast.
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
     * Moves the ball according to its current speed.
     */
    private void moveBall()
    {
        //Moves the Ball according to direction and speed
        setLocation(getX() + xSpeed, getY()+ySpeed);
        
    }
    
    /**
     * Checks for collision with players and reverses horizontal direction if touching.
     * Plays a kick sound effect.
     */
    private void checkPlayerBounce()
    {
        //If Ball touches Player : horizontal speed turns negative 
        //making it move in the opposite direction
        if(isTouching(PersonOne.class) || isTouching(PersonTwo.class))
        {
            xSpeed = xSpeed*-1;
            kickSound.play();
        }
        
    }
    
    /**
     * Changes the vertical direction and slightly increases horizontal 
     * speed when bouncing off walls to increase difficulty as game 
     * progresses.
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
     * Checks for collisions with the top and bottom edges of the world and triggers bounce.
     */
    private void checkWallBounce()
    {
        //Checks if ball touching top or bottom part of the world 
        DoublePlayerWorld world = (DoublePlayerWorld)getWorld();
        
        if(getY() <= 0)
        {
            bounce();
        }    
        else if (getY() >= world.getHeight()-1) 
        {
            bounce();
        }    
        
        
    }
    
    /**
     * Checks if the ball has passed players, indicating a score.
     * Updates the score and resets the ball position.
     */
    private void checkEdges() {
        if (getX() <= 0) {
            // Player 2 scores
            roundOver.play();
            DoublePlayerWorld world = (DoublePlayerWorld)getWorld();
            world.addScoreToPlayer2();
            resetBall();
            roundStart.play();
        } else if (getX() >= getWorld().getWidth() - 1) {
            // Player 1 scores
            roundOver.play();
            DoublePlayerWorld world = (DoublePlayerWorld)getWorld();
            world.addScoreToPlayer1();
            resetBall();
            roundStart.play();
        }
    }
    
    
    /**
     * Resets the ball to the center of the world and delays briefly.
     */
    private void resetBall() {
        setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.delay(200);
        
    }
    
     /**
     * Checks if either player has reached score  of 10 and ends the game 
     * if so.
     */
    private void checkGameOver()
    {
        DoublePlayerWorld world = (DoublePlayerWorld) getWorld();
        
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
