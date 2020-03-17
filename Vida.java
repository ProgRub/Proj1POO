import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Vida extends ObjetosCaem
{
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
