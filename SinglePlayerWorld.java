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
        
        SinglePlayerScore board = new SinglePlayerScore();
        addObject(board,getWidth()/2,40);
               
        // Initialize labels
        player1Label = new Label("0", 20);
        player2Label = new Label("0", 20);


        // Add them to the world
        addObject(player1Label, getWidth()/2-30, 45);
        addObject(player2Label, getWidth()/2+30, 45);
    }
    
    
    public void addScoreToPlayer1() {
        player1Score++;
        player1Label.setValue(player1Score);
        addPotion();
        addBanana();
        addStar();
    }
    
    public void addScoreToPlayer2() {
        player2Score++;
        player2Label.setValue(player2Score);
        addPotion();
        addBanana();
        addStar();
    }
    
    private void addPotion()
    {
        removeObjects(getObjects(Potion.class));
        //40% chance
        if(Greenfoot.getRandomNumber(10)==5)
        {
            int potionX = 300+Greenfoot.getRandomNumber(60)-40;
            int potionY = 300+Greenfoot.getRandomNumber(80)-40;
            Potion potion = new Potion();
            addObject(potion,potionX,potionY);
            
        }
    }

    public void addBanana()
    {
        removeObjects(getObjects(Banana.class));
        //20% chance
        if(Greenfoot.getRandomNumber(10)>0)
        {
            int bananaX = 300+Greenfoot.getRandomNumber(60)-40;
            int bananaY = 300+Greenfoot.getRandomNumber(80)-40;
            Banana banana = new Banana();
            addObject(banana,bananaX,bananaY);
            
        }
        
    }
    
    public void addStar()
    {
        removeObjects(getObjects(Star.class));
        //20% chance
        if(Greenfoot.getRandomNumber(10)>0)
        {
            int starX = 300+Greenfoot.getRandomNumber(60)-40;
            int starY = 300+Greenfoot.getRandomNumber(80)-40;
            Star star = new Star();
            addObject(star,starX,starY);
            
        }
    }
    public void gameOver()
    {
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
    }    
}
