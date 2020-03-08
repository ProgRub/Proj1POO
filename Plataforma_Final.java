import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plataforma_Final extends PlataformaGelo
{
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