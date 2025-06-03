import greenfoot.*;


public class SinglePlayerWorld extends World {
    
    //Players counters
    public int player1Score = 0;
    public int player2Score = 0;
    
    //Labels to display the players score
    private Label player1Label;
    private Label player2Label;
    
    public SinglePlayerWorld() {
        super(600, 400, 1);
        
        //set background
        setBackground("images/background_soccer.jpg ");
        
        //add the ball for single player
        SinglePlayerBall ball = new SinglePlayerBall();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        //add the player one model
        PersonOne personOne = new PersonOne();
        addObject(personOne, 50, 200);
        
        //add the computer model
        ComputerPlayer computer = new ComputerPlayer(ball);
        addObject(computer,550,200);
        
        // Initialize labels
        player1Label = new Label("Player 1: 0", 30);
        player2Label = new Label("Player 2: 0", 30);

        // Add them to the world
        addObject(player1Label, 150, 30);
        addObject(player2Label, 450, 30);
    }
    
    
    public void addScoreToPlayer1() {
        // add score to player one and update label
        player1Score++;
        player1Label.setValue("Player 1: " + player1Score);
    }
    
    public void addScoreToPlayer2() {
        //add score to player two and update label
        player2Score++;
        player2Label.setValue("Player 2: " + player2Score);
    }
    
    public void gameOver()
    {
        //ends the game and transitions to game over screen
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
    }    
}
