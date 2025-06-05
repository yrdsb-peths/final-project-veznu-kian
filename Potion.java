import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPerk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends Actor
{
    public Potion()
    {
        setImage("images/potion.png");
    }
    
    public void act()
    {
        if(isTouching(SinglePlayerBall.class)) 
        {
            PersonOne player1 = (PersonOne) getWorld().getObjects(PersonOne.class).get(0);
            player1.enlarge();
            getWorld().removeObject(this);
            
        }
    }
}
