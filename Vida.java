import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Vida extends ObjetosCaem
{
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageVida;
    public Vida()

    {
        imageVida = getImage();
        imageVida.scale(imageVida.getWidth()/2, imageVida.getHeight()/2);

    }
    
    public void act() 
    {
        movimentoVida();
        ultrapassaLimite();
    }   
    
    /**
     * A "Vida" tem um movimento descendente mais lento que os restantes "ObjetosCaem", para o jogo 1
     */
    private void movimentoVida() 
    { 
        setLocation(getX(), getY() + 4);
    }      
}
