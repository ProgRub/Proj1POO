import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandeira_Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandeira_Start extends Jogos
{
    /**
     * Act - do whatever the Bandeira_Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int contador;
    
    public Bandeira_Start()
    {
        contador =0;
    }
    
    public void act() 
    {
        desaparecer();
        permanecerParado();
    } 
    
    public void permanecerParado()
    {
        if (contador >650)
        {
            move(-1);
        }
        contador++;
        
    }
    
    public void desaparecer(){
        if (getX() == 0){
            getWorld().removeObject(this);
        }
    }
}