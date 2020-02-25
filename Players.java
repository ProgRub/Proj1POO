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

    public int aux;

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
        if(P1.numeroVidas>0){
            if(isTouching(Granizo.class))
            {
                P1.numeroVidas--; 
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (aux==0)
                {
                    P1.numeroVidas =  P1.numeroVidas - 2;
                    aux = 20;
                }
                else
                {
                    aux--;
                }
            }

            if(isTouching(Vida.class))
            {
                if(P1.numeroVidas >= 9)
                {
                    P1.numeroVidas = 10;
                }

                else
                {
                    P1.numeroVidas = P1.numeroVidas + 2;
                } 
                removeTouching(Vida.class);
            }
        }
        else{
            //getWorld().removeObject(this);
        }

    }

    protected void perdeVidas(Player2 P2)
    {
        if(P2.numeroVidas>0){
            if(isTouching(Granizo.class))
            {
                P2.numeroVidas--; 
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (aux==0)
                {
                    P2.numeroVidas =  P2.numeroVidas - 2;
                    aux = 20;
                }
                else
                {
                    aux--;
                }
            }

            if(isTouching(Vida.class))
            {
                if(P2.numeroVidas >= 9)
                {
                    P2.numeroVidas = 10;
                }

                else
                {
                    P2.numeroVidas = P2.numeroVidas + 2;
                } 
                removeTouching(Vida.class);
            }
        }
        else{
            //getWorld().removeObject(this);
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

