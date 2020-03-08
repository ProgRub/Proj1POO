import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CamadaOzono extends Jogos
{
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
    
    /**
     * Método que regista a perda de vida da camada de ozono e torna esta mais transparente de acordo com a vida que tem
     */
    private void mudarTransparencia()
    {
        if (isTouching(Gas.class))
        {
            imageCamada.setTransparency(2*vida+5);
            vida--;           
            removeTouching(Gas.class);            
        }
    }
    
}
