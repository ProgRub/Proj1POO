import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players extends Actor
{
    /**
     * Act - do whatever the Players wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int aux;

    public void act() 
    {
    }  

    public Players()
    {
        aux = 15; 
    }

    protected void perdeVidas(Player1 P1)
    {
        if(P1.getNumeroVidas()>0){
            if(isTouching(Granizo.class))
            {
                P1.adicionaNumeroVidas(-1); 
                P1.adicionaScore(-5);
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (aux==0)
                {
                    P1.adicionaNumeroVidas(-2);
                    P1.adicionaScore(-10);
                    aux = 15;
                }
                else
                {
                    aux--;
                }
            }

            if(isTouching(Vida.class) )
            {
                P1.adicionaNumeroVidas(2);
                P1.adicionaScore(5);
                removeTouching(Vida.class);

            }
        }

    }

    protected void perdeVidas(Player2 P2)
    {
        if(P2.getNumeroVidas()>0){
            if(isTouching(Granizo.class))
            {
                P2.adicionaNumeroVidas(-1); 
                P2.adicionaScore(-5);
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (aux==0)
                {
                    P2.adicionaNumeroVidas(-2); 
                    P2.adicionaScore(-10);
                    aux = 20;
                }
                else
                {
                    aux--;
                }
            }

            if(isTouching(Vida.class))
            {
                P2.adicionaNumeroVidas(2); 
                P2.adicionaScore(5);
                removeTouching(Vida.class);
            }
        }
    }

    protected void perdeVidas(Nave1 N1)
    {
        if(N1.getNumeroVidas()>0)
        {

            if(isTouching(Vida_jogo2.class))
            {
                N1.adicionaNumeroVidas(2);
                removeTouching(Vida_jogo2.class);
            }
        }

    }

    protected void perdeVidas(Nave2 N2)
    {
        if(N2.getNumeroVidas()>0)
        {
            if(isTouching(Vida_jogo2.class))
            {
                N2.adicionaNumeroVidas(1); 
                removeTouching(Vida_jogo2.class);
            }

        }

    }

    public static boolean podeMudar(String[] P1Controls, String[] P2Controls, String key){
        for (int i=0; i<4;i++){
            if (key.equals(P1Controls[i]) || key.equals(P2Controls[i])){
                return false;
            }
        }
        return true;
    }
    
}

