import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Jogos
{
    GreenfootImage pisca1, pisca2;
    
    public GameOver(){
        pisca1 = new GreenfootImage("gameOVER.png");
        pisca2 = new GreenfootImage("gameOVER1.png");
    }
    
    public void act() 
    {
        pisca();
    }  
    
    public void pisca(){
        setImage(pisca1);
        Greenfoot.delay(10);
        setImage(pisca2);
        Greenfoot.delay(10);
    }
}
