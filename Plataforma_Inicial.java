import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataforma_Inicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plataforma_Inicial extends PlataformaGelo
{
    /**
     * Act - do whatever the Plataforma_Inicial wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int contador;
    
    public Plataforma_Inicial()
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
}
