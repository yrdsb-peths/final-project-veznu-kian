import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoublePlayerWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoublePlayerWorld extends World
{
    
    //player one score counter
    public int player1Score = 0;
    
    //Player two score counter
    public int player2Score = 0;
    
    //Labels to display the scores
    private Label player1Label;
    private Label player2Label;
    
    // Added crowd sounds to the game world.
    GreenfootSound crowd = new GreenfootSound("sounds/crowd.mp3");
    
    // Background Music for Game 
    GreenfootSound arcadeMusic = new GreenfootSound("sounds/retro-game-arcade-236133.mp3");
    
    public DoublePlayerWorld() {
        super(600, 400, 1);
        
        //Plays background music
        arcadeMusic.play();
        arcadeMusic.setVolume(50);
        
        setBackground("images/background_soccer.jpg"); // set the background image
        
        DoublePlayerScore board = new DoublePlayerScore();
        addObject(board,getWidth()/2,40);
        
        //Add the ball into the center of the field / world
        DoublePlayerBall ball = new DoublePlayerBall();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        // Add Player 1 to the left side
        PersonOne personOne = new PersonOne();
        addObject(personOne, 50, 200);
        
        //Add Player 2 to the right side
        PersonTwo personTwo = new PersonTwo();
        addObject(personTwo,550,200);
        
        // Initialize labels
        player1Label = new Label("0", 20);
        player2Label = new Label("0", 20);

        // Add them to the world
        addObject(player1Label, getWidth()/2-30, 45);
        addObject(player2Label, getWidth()/2+30, 45);
    }
    
    public void act()
    {
        //Plays background music
        arcadeMusic.play();
        arcadeMusic.setVolume(40);
    
    }
    
    /*
     * This method when called, adds a point to player 1
     */
    public void addScoreToPlayer1() {
        //Add's a point to player 1's score and updates the label
        player1Score++;
        player1Label.setValue(player1Score);
        crowd.setVolume(30);
        crowd.play();
    }
    
    /*
     * This method when called, adds a point to player 2
     */
    public void addScoreToPlayer2() {
        // adds a point to player 2's score and updates the label
        player2Score++;
        player2Label.setValue(player2Score);
        crowd.setVolume(30);
        crowd.play();
    }
    
    /*
     * This method when called sets the screen to the game over screen
     */
    public void gameOver()
    {
        //ends the game and transitions to the EndWorld screen.
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
        arcadeMusic.stop();
    }   
}
