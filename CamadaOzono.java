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
    private static int vida;
    
    public CamadaOzono(){
        imageCamada= getImage();
        vida=125;
        imageCamada.setTransparency(2*vida+5);
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
            imageCamada.setTransparency(2*vida+5);
            vida--;           
            removeTouching(Gas.class);
            
        }
    }
    
}
