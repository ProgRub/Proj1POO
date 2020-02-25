
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave1 extends Player1
{
<<<<<<< HEAD
    
    
    
    
=======
    private static String left=Player1.getControls()[1];
    private static String right=Player1.getControls()[2];
    private static int vida;
    
    public Nave1()
    {
        vida=Player1.getNumeroVidas();
    }
>>>>>>> d67e199ddb98f4b1a4f7e4d3cc12e176f22610af
    
    public void act() 
    {
        moveNave();
        removeGas();
        
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
            removeTouching(Gas.class);
            
        }
    }
    
<<<<<<< HEAD
    
=======
    public static int getNumeroVidas()
    {
        return vida;
    }
    
    public static void tiraNumeroVidas(int valor)
    {
        vida+=valor;
    }
>>>>>>> d67e199ddb98f4b1a4f7e4d3cc12e176f22610af
}
