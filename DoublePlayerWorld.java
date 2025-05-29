import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoublePlayerWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoublePlayerWorld extends World
{
    
    public int player1Score = 0;
    public int player2Score = 0;
    
    private Label player1Label;
    private Label player2Label;
    
    public DoublePlayerWorld() {
        super(600, 400, 1);
        
        setBackground("images/background_soccer.jpg ");
        DoublePlayerBall ball = new DoublePlayerBall();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        PersonOne personOne = new PersonOne();
        addObject(personOne, 50, 200);
        
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
        player1Score++;
        player1Label.setValue("Player 1: " + player1Score);
    }
    
    public void addScoreToPlayer2() {
        player2Score++;
        player2Label.setValue("Player 2: " + player2Score);
    }
    
    public void gameOver()
    {
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
    }   
}
