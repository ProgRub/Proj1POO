import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Neve_ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Neve_ extends Actor
{
    /**
     * Act - do whatever the Neve_ wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimentoNeve();
        ultrapassaLimite();
    }   

    public void ultrapassaLimite(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

    public void movimentoNeve(){
        setLocation(getX()-1, getY() + 8);
    }   
}
