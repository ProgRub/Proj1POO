import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandeira_Finish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandeira_Finish extends Jogos
{
    /**
     * Act - do whatever the Bandeira_Finish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    private int contador;
    
    public Bandeira_Finish()
    {
        contador =0;
    }
    
    public void act() 
    {
        
        permanecerParado();
    } 
    
    public void permanecerParado()
    {
        if (contador<100)
        {
            move(-1);
        }
        contador++;
        
    }
}
