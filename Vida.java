import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        movimentoVida(); //para o jogo 1
        ultrapassaLimite();
    }   

    private void movimentoVida()  //A "Vida" tem um movimento descendente mais lento que os restantes "ObjetosCaem"
    { 
        setLocation(getX(), getY() + 4);
    }      
}
