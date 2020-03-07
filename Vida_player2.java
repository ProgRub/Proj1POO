import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_player2 extends Player2
{
    /**
     * Act - do whatever the Vida_player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] vidas;
    private Player2 P2=null;

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
        vidaPlayer2(P2);
    }   


    public void vidaPlayer2(Player2 P2)
    {
        if (P2.getNumeroVidas() >0)
        {
            setImage(vidas[P2.getNumeroVidas()-1]);
        }
        else {
            getWorld().removeObject(this);
        }    
    }   

}
