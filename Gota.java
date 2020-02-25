import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gota extends ObjetosCaem
{
    /**
     * Act - do whatever the Gota wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimento();
        ultrapassaLimite();
    }    
}
