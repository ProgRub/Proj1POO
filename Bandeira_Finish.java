import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bandeira_Finish extends Jogos
{
    private int contador; 
    
    public Bandeira_Finish()
    {
        contador = 0;  
    }
    
    public void act() 
    {
        permanecerParado();
    } 
    

    /**
     * Método que move a bandeira de acordo com o movimento da plataforma final, que é onde esta bandeira estará
     */
    public void permanecerParado()

    {
        if (contador<100) 
        {
            move(-1);
        }
        contador++; 
        
    }
}
