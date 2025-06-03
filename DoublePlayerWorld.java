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
    
    //labels to display the scores
    private Label player1Label;
    private Label player2Label;
    
    public DoublePlayerWorld() {
        super(600, 400, 1);
        
        setBackground("images/background_soccer.jpg "); // set the background image
        
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
        player1Label = new Label("Player 1: 0", 30);
        player2Label = new Label("Player 2: 0", 30);

        // Add them to the world
        addObject(player1Label, 150, 30);
        addObject(player2Label, 450, 30);
    }
    
    public void addScoreToPlayer1() {
        //Add's a point to player 1's score and updates the label
        player1Score++;
        player1Label.setValue("Player 1: " + player1Score);
    }
    
    public void addScoreToPlayer2() {
        // adds a point to player 2's score and updates the label
        player2Score++;
        player2Label.setValue("Player 2: " + player2Score);
    }
    
    public void gameOver()
    {
        //ends the game and transitions to the EndWorld screen.
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
    }   
}
