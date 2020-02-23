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

    protected void perdeVidas(Player1 player1)
    {
        if(isTouching(Granizo.class))
        {
            player1.numeroVidas--; 
            removeTouching(Granizo.class);
        }
        
        if(isTouching(Relâmpago.class))
        {
            if (aux==0)
            {
                if (player1.numeroVidas == 1)
                {
                    player1.numeroVidas--;
                }
                
                else
                {
                    player1.numeroVidas =  player1.numeroVidas - 2;
                    removeTouching(Relâmpago.class);
                    aux = 20;
                
                }
            }
            else
            {
                aux--;
            }
        }
        
        
    }

    protected void perdeVidas(Player2 player2)
    {
        if(isTouching(Granizo.class))
        {
            player2.numeroVidas--; 
            removeTouching(Granizo.class);
        }
        
        if(isTouching(Relâmpago.class))
        {
            if (aux==0)
            {
                if (player2.numeroVidas == 1)
                {
                    player2.numeroVidas--;
                }
                
                else
                {
                    player2.numeroVidas =  player2.numeroVidas - 2;
                    removeTouching(Relâmpago.class);
                    aux = 20;
                
                }
                
            }
            else
            {
                aux--;
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

