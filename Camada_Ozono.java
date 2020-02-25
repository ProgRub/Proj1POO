import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Camada_Ozono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camada_Ozono extends Actor
{
    /**
     * Act - do whatever the Camada_Ozono wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage imageCamada;
    private int aux;
    
    public void act() 
    {
        mudarTransparencia();
    }  
    
    public Camada_Ozono()
    {
        imageCamada= getImage();
        aux=0;
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
            
            aux++;
            
            removeTouching(Gas.class);
            
        }
    }
    
}
