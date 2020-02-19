import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1300x700 cells with a cell size of 1x1 pixels.
        super(1300,700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(1300, 700);
        setBackground(bg);
        
    }
}
