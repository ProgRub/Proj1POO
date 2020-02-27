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
        // Add your action code here.
    }  

    public Players()
    {
        aux = 19; 
    }

    protected void perdeVidas(Player1 P1)
    {
        if(P1.getNumeroVidas()>0){
            if(isTouching(Granizo.class))
            {
                P1.adicionaNumeroVidas(-1); 
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (aux==0)
                {
                    P1.adicionaNumeroVidas(-2);
                    aux = 20;
                }
                else
                {
                    aux--;
                }
            }

            if(isTouching(Vida.class) )
            {
                if(P1.getNumeroVidas() >= 9)
                {
                    P1.adicionaNumeroVidas(1);
                }

                else
                {
                    P1.adicionaNumeroVidas(2);
                } 
                removeTouching(Vida.class);

            }
        }
        else{
            //animarMorte();
            //getWorld().removeObject(this);
        }

    }

    protected void perdeVidas(Player2 P2)
    {
        if(P2.getNumeroVidas()>0){
            if(isTouching(Granizo.class))
            {
                P2.adicionaNumeroVidas(-1); 
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (aux==0)
                {
                    P2.adicionaNumeroVidas(-2); 
                    aux = 20;
                }
                else
                {
                    aux--;
                }
            }

            if(isTouching(Vida.class))
            {
                if(P2.getNumeroVidas() >= 9)
                {
                    P2.adicionaNumeroVidas(1); 
                }

                else
                {
                    P2.adicionaNumeroVidas(2); 
                } 
                removeTouching(Vida.class);
            }
        }
        else{
            //animarMorte();
            //getWorld().removeObject(this);
        }
    }

    
    protected void perdeVidas(Nave1 N1)
    {
        if(N1.getNumeroVidas()>0)
        {

            if(isTouching(Vida_jogo2.class))
            {
                if(N1.getNumeroVidas() >= 9)
                {
                    N1.tiraNumeroVidas(1); 
                }

                else
                {
                    N1.tiraNumeroVidas(2); 
                } 
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
                if(N2.getNumeroVidas() >= 9)
                {
                    N2.tiraNumeroVidas(1); 
                }

                else
                {
                    N2.tiraNumeroVidas(2); 
                } 
                removeTouching(Vida_jogo2.class);
            }

        }

    }

    

    public static boolean podeMudar(String[] P1Controls, String[] P2Controls, String key){
        for (int i=0; i<5;i++){
            if (key.equals(P1Controls[i]) || key.equals(P2Controls[i])){
                return false;
            }
        }
        return true;
    }
}

