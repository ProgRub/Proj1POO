import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nuvem2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nuvem2 extends Nuvem
{
    /**
     * Act - do whatever the Nuvem2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int aux;
    
    public Nuvem2()
    {
        aux=0;
    }
    
    public void act() 
    {
        movimentoNuvem2();
    }  
    
    private void movimentoNuvem2(){
        if (aux<125)
        {
            move(-3);
           
        }
        if (Greenfoot.getRandomNumber(100)<2 && aux>19){
            setLocation(getX()+ Greenfoot.getRandomNumber(20)-10, getY());
            
        }
        aux++;
          
    }
}
