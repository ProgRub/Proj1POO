import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plataforma_Inicial extends PlataformaGelo
{
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
