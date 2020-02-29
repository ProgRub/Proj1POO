
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave1 extends Player1
{

    
    public Nave1()
    {
        setImage(getColor()+"/Nave.png");
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
    }

    public void act() 
    {
        moveNave();
        removeGas(); 
        perdeVidas(this);
    } 

    public void moveNave(){
        if (Greenfoot.isKeyDown(left)){
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown(right)){
            setLocation(getX()+3, getY());
        }
    }

    public void removeGas()
    {
        if (isTouching(Gas.class))
        {
            Player1.adicionaScore(10);
            removeTouching(Gas.class);
            
        }
    }
    

}
