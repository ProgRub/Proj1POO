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
            vida--;
            if(vida<=0) //este if evita que a transparencia seja um valor negativo, o que gera erro de compilação
            {
                getWorld().removeObject(this);
            }
            else
            {
                imageCamada.setTransparency(2*vida+5);
                removeTouching(Gas.class);            
            }

        }
    }

}