import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_player1 extends Player1
{
    /**
     * Act - do whatever the Vida_player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] vidas;
    private Player1 P1=null;

    public Vida_player1()
    {
        vidas = new GreenfootImage[10];
        for (int i=0; i < vidas.length; i++)
        {
            vidas[i] = new GreenfootImage("Vida/"+(i+1)+".png");
        }
    }


    public void act() 
    {
            vidaPlayer1(P1);
    }   

    public void vidaPlayer1(Player1 P1)
    {
        if (P1.getNumeroVidas() >0)
        {
            setImage(vidas[P1.getNumeroVidas()-1]);
        }
        else {
            getWorld().removeObject(this);
        }    
    }  
}
