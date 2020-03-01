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
    private int sentido;
    
    public Nuvem(int sentidoMovimento)
    {
        aux=0;
        sentido=sentidoMovimento;
       
    }
    
    public void act() 
    {
        movimentoNuvem(sentido);
    }  
    
    private void movimentoNuvem(int sentido){
        if (aux<105)
        {
            move(sentido*3);
           
        }
        if (Greenfoot.getRandomNumber(100)<2 && aux>19){
            setLocation(getX()+ Greenfoot.getRandomNumber(20)-10, getY());
            
        }
        aux++;
          
    }
    
}
