
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave1 extends Player1
{

    private static String left=Player1.getControls()[1];
    private static String right=Player1.getControls()[2];
    private static int vida;
    
    public Nave1()
    {
        setImage(Player1.getColor()+"/Nave.png");
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
            removeTouching(Gas.class);
            
        }
    }
    

    public static int getNumeroVidas()
    {
        return vida;
    }
    
    public static void setNumeroVidas(int numVidas)
    {
        vida = numVidas;
    }
    
    public static void tiraNumeroVidas(int valor)
    {
        vida+=valor;
    }
    

}
