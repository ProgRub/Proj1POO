import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_1 extends Vidas
{
    /**
     * Act - do whatever the Vida_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageCoracoes;
    public Vida_1()
    {
        imageCoracoes = getImage();
        int larguraAtual = imageCoracoes.getWidth();
        int alturaAtual = imageCoracoes.getHeight();
        imageCoracoes.scale(larguraAtual/2, alturaAtual/2);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
