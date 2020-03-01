import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_jogo2 extends Vida
{
    /**
     * Act - do whatever the Vida_jogo2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimentoVida();
        ultrapassaLimite();
    } 
    
    public void movimentoVida(){
        setLocation(getX(), getY() - 3);
    }   
    
    protected void ultrapassaLimite(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
