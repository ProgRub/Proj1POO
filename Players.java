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
    public void act() 
    {
        // Add your action code here.
    }  

    protected void perdeVidas(Player1 player1)
    {
        if(isTouching(Granizo.class))
        {
            player1.numeroVidas--; 
            removeTouching(Granizo.class);
        }
    }

    protected void perdeVidas(Player2 player2)
    {
        if(isTouching(Granizo.class))
        {
            player2.numeroVidas--; 
            removeTouching(Granizo.class);
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

