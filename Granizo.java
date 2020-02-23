import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Granizo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Granizo extends Actor
{
    /**
     * Act - do whatever the Granizo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageGranizo;
    public Granizo()

    {
        imageGranizo = getImage();
        int larguraAtual = imageGranizo.getWidth();
        int alturaAtual = imageGranizo.getHeight();
        imageGranizo.scale(larguraAtual/3, alturaAtual/3);

    }

    public void act() 
    {
        movimentoGranizo();
        ultrapassaLimite();
    }   

    public void ultrapassaLimite(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

    public void movimentoGranizo(){
        setLocation(getX()-1, getY() + 8);
    }   
}
