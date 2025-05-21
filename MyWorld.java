import greenfoot.*;


public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        setBackground("images/background.jfif ");
        Ball ball = new Ball();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        BlockOne blockOne = new BlockOne();
        addObject(blockOne, 25, 200);
        
        BlockTwo blockTwo = new BlockTwo();
        addObject(blockTwo, 575, 200);
    }
}
