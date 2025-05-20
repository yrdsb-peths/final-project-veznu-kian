import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Ball ball = new Ball();
        addObject(ball,getWidth()/2,getHeight()/2);
        
    }
}
