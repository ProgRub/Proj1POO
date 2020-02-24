import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    private int count;
    private final int TIMER;
    private int count2;
    GreenfootImage semBrilho,comBrilho;
    public Target(){
        semBrilho = new GreenfootImage("targetf.png");
        comBrilho = new GreenfootImage("target8.png");
        setImage(semBrilho);
        TIMER=5;
        count = TIMER*4;
        count2 = 0;
    }
    
    public void act() 
    {
        switchImage();
    }
    
    public void switchImage()
    {
        if (count2%TIMER==0){
            if (getImage() == semBrilho)
            {
                setImage(comBrilho);
            }

            else if (getImage() == comBrilho)
            {
                setImage(semBrilho);
            }
        }  
        count2++;     
    }
}
