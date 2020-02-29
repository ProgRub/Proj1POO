import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nuvem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nuvem extends Jogos
{
    /**
     * Act - do whatever the Nuvem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int aux;
    
    
    public Nuvem()
    {
        aux=0;
    }
    
    public void act() 
    {
        movimentoNuvem();
    }  
    
    private void movimentoNuvem(){
        if (aux<105)
        {
            move(3);
           
        }
        if (Greenfoot.getRandomNumber(100)<2 && aux>19){
            setLocation(getX()+ Greenfoot.getRandomNumber(20)-10, getY());
            
        }
        aux++;
          
    }
    
}
