import greenfoot.*;


public class SinglePlayerWorld extends World {
    // Create variables for each players score
    public int player1Score = 0;
    public int player2Score = 0;
    
    //Create labels for said variables
    private Label player1Label;
    private Label player2Label;
    
    public SinglePlayerWorld() {
        super(600, 400, 1);
        
        //Set background of game
        setBackground("images/background_soccer.jpg ");
        
        //Add ball to world
        SinglePlayerBall ball = new SinglePlayerBall();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        //Add Player one to the world
        PersonOne personOne = new PersonOne();
        addObject(personOne, 50, 200);
        
        //Add computer to the world
        ComputerPlayer computer = new ComputerPlayer(ball);
        addObject(computer,550,200);
        
        //Add the board where the score is held
        SinglePlayerScore board = new SinglePlayerScore();
        addObject(board,getWidth()/2,40);
               
        // Initialize labels
        player1Label = new Label("0", 20);
        player2Label = new Label("0", 20);


        // Add them to the world
        addObject(player1Label, getWidth()/2-30, 45);
        addObject(player2Label, getWidth()/2+30, 45);
    }
    
    
    //method to adding score to each variable
    public void addScoreToPlayer1() {
        player1Score++;
        player1Label.setValue(player1Score);
        addPotion();
    }
    
    public void addScoreToPlayer2() {
        player2Score++;
        player2Label.setValue(player2Score);
        addPotion();
    }
    
    //Adds "perk" or potion into the world 
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
