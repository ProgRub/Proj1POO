import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_player2 extends Player2
{
    private GreenfootImage[] vidas;

    public Vida_player2()
    {
        vidas = new GreenfootImage[10];
        for (int i=0; i < vidas.length; i++)
        {
            vidas[i] = new GreenfootImage("Vida/"+(i+1)+".png");
            vidas[i].mirrorHorizontally();
        }
    }

    public void act() 
    {
        vidaPlayer2();
    }   

    public void vidaPlayer2()
    {
        if (Player2.getNumeroVidas() >0)
        {
            setImage(vidas[Player2.getNumeroVidas()-1]);
        }
        else {
            getWorld().removeObject(this);
        }    
    }   

}
