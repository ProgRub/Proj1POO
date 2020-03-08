import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
