import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave2 extends Player2
{
    private static String left=Player2.getControls()[1];
    private static String right=Player2.getControls()[2];
    private static int vida;
    
    public Nave2()
    {
        vida=Player2.getNumeroVidas();
    }
    
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
        if (isTouching (Gas.class))
        {
            removeTouching (Gas.class);

        }
    }
    
    public static int getNumeroVidas()
    {
        return vida;
    }
    
    public static void tiraNumeroVidas(int valor)
    {
        vida+=valor;
    }
}
