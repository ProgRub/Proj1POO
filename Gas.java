import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Actor
{
    final int dano = 10;
    int direcaoGas;
    
    public void act() 
    {
        movimentoGas();
        ultrapassaLimite();
    }   
    
    public void ultrapassaLimite(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    public void movimentoGas(){
        setLocation(getX()+ Greenfoot.getRandomNumber(11)-5, getY() - 1);
    }
}
