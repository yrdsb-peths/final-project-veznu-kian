import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OptionBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionBackground extends Actor
{
    public void background()
    {
        GreenfootImage img = new GreenfootImage("images/optionBackground.jpg");
        img.scale(400,500);
        setImage(img);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
