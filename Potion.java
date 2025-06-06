import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPerk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Only for singleplayer world
public class Potion extends Actor
{
    GreenfootSound collectEffect = new GreenfootSound("sounds/collectEffect.mp3");
    public Potion()
    {
        //Set image for the potion
        setImage("images/potion.png");
    }
    
    public void act()
    {
        if(isTouching(SinglePlayerBall.class)) 
        {
            //Collect potion and enlarges the player 1
            PersonOne player1 = (PersonOne) getWorld().getObjects(PersonOne.class).get(0);
            player1.enlarge();
            collectEffect.play();
            getWorld().removeObject(this);
            
        }
    }
}
