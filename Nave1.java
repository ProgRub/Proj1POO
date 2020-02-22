import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave1 extends Naves
{

    public void act() 
    {
        moveNave();
        removeGas();
    } 

    public void moveNave(){
        if (Greenfoot.isKeyDown("a")){
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("d")){
            setLocation(getX()+3, getY());
        }
    }

    public void removeGas()
    {
        if (isTouching (Gas.class))
        {
            removeTouching (Gas.class);
        }
    }
}
