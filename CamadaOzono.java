import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CamadaOzono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CamadaOzono extends Jogos
{
    /**
     * Act - do whatever the CamadaOzono wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageCamada;
    private int aux;
    private static int vida =25;
    
    public CamadaOzono(){
        imageCamada= getImage();
        aux=0;
        vida = 25;
    }
    
    public void act() 
    {
        mudarTransparencia();
    }  
    
    public static int getVida(){
        return vida;
    }
    public void mudarTransparencia()
    {
        if (isTouching(Gas.class))
        {
            if ( aux >= 5 && aux < 10)
            {
                imageCamada.setTransparency(200);
            }
            
            if ( aux >= 10 && aux < 15)
            {
                imageCamada.setTransparency(150);
                
            }
            
            if ( aux >= 15 && aux < 20)
            {
                imageCamada.setTransparency(100);
               
            }
            
            if ( aux >= 20 && aux < 25)
            {
                imageCamada.setTransparency(50);
                
            }
            
            if ( aux >= 25)
            {
               imageCamada.setTransparency(0); 
               
            }
            vida--;
            getWorldOfType(Jogo2.class).getObjects(VidaCamadaOzono.class).get(0).perdeVida();
            aux++;
            
            removeTouching(Gas.class);
            
        }
    }
    
}
