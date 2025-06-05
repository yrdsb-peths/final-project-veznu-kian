import greenfoot.*;


public class SinglePlayerWorld extends World {
    public int player1Score = 0;
    public int player2Score = 0;
    
    private Label player1Label;
    private Label player2Label;
    
    public SinglePlayerWorld() {
        super(600, 400, 1);
        
        setBackground("images/background_soccer.jpg ");
        SinglePlayerBall ball = new SinglePlayerBall();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        PersonOne personOne = new PersonOne();
        addObject(personOne, 50, 200);
        
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
        player1Score++;
        player1Label.setValue("Player 1: " + player1Score);
        addPotion();
    }
    
    public void addScoreToPlayer2() {
        player2Score++;
        player2Label.setValue("Player 2: " + player2Score);
        addPotion();
    }
    
    private void addPotion()
    {
        removeObjects(getObjects(Potion.class));
        //40% chance
        if(Greenfoot.getRandomNumber(10)>6)
        {
            int potionX = 300+Greenfoot.getRandomNumber(60)-40;
            int potionY = 300+Greenfoot.getRandomNumber(80)-40;
            Potion potion = new Potion();
            addObject(potion,potionX,potionY);
            
        }
    }
    public void gameOver()
    {
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
    }    
}
