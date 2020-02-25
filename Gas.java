import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Jogos
{
    private final int dano = 10;

    public void act() 
    {
        movimentoGas();
        ultrapassaLimite();
    }   

<<<<<<< HEAD
    public void ultrapassaLimite(){
        if(getY()==0){
=======
    private void ultrapassaLimite(){
        if(isAtEdge()){
>>>>>>> d67e199ddb98f4b1a4f7e4d3cc12e176f22610af
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
