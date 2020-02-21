import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave2 extends Naves
{
    /**
     * Act - do whatever the Nave2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveNave();
    }    
    public void moveNave(){
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+3, getY());
        }
    }
}
