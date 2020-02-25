import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Actor
{
    private final int dano = 10;

    public void act() 
    {
        movimentoGas();
        ultrapassaLimite();
    }   

    private void ultrapassaLimite(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

    private void movimentoGas(){
        if (Greenfoot.getRandomNumber(100)<5){
            setLocation(getX()+ Greenfoot.getRandomNumber(11)-5, getY());
        }
        setLocation(getX(), getY() - 1);
    }
}
