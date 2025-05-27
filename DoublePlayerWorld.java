import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoublePlayerWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoublePlayerWorld extends World
{
    public DoublePlayerWorld() {
        super(600, 400, 1);
        
        setBackground("images/background_soccer.jpg ");
        DoublePlayerBall ball = new DoublePlayerBall();
        addObject(ball,getWidth()/2,getHeight()/2);
        
        PersonOne personOne = new PersonOne();
        addObject(personOne, 50, 200);
        
        PersonTwo personTwo = new PersonTwo();
        addObject(personTwo,550,200);
    }
    
    public void gameOver()
    {
        EndWorld gameOver = new EndWorld();
        Greenfoot.setWorld(gameOver);
    }   
}
