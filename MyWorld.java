import greenfoot.*;


public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        setBackground("images/background_soccer.jpg ");
        Ball ball = new Ball();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        BlockOne blockOne = new BlockOne();
        addObject(blockOne, 50, 200);
        
        BlockTwo blockTwo = new BlockTwo();
        addObject(blockTwo, 550, 200);
    }
    
    public void deflect()
    {
    
        
        
        
    }    
}
