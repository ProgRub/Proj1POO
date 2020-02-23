import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Neve here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Neve extends Granizo
{
    /**
     * Act - do whatever the Neve wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimentoGranizo();
        ultrapassaLimite();
    }    
}
