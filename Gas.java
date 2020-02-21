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
    public Gas(){
        //
    }
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
        direcaoGas = Greenfoot.getRandomNumber(2)-1;
        if (Greenfoot.getRandomNumber(100)<50){
            setLocation(getX()+ direcaoGas, getY() - 1);
        }
    }
}
