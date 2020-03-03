import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataforma_Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plataforma_Final extends PlataformaGelo
{
    /**
     * Act - do whatever the Plataforma_Final wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage image;
    private int contador;
    
    public Plataforma_Final()
    {
        contador =0;
        setImage("plat_final.png");
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