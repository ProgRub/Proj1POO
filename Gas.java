import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Jogos
{

    public void act() 
    {
        movimentoGas();
        ultrapassaLimite();
    }   
    
    /**
     * Método que remove o objeto quando chega ao limite do mundo
     */
    private void ultrapassaLimite()
    {
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Método que move o objeto para cima e talvez para os lados, para torná-lo mais realista
     */
    private void movimentoGas(){
        if (Greenfoot.getRandomNumber(100)<10){
            setLocation(getX()+ Greenfoot.getRandomNumber(11)-5, getY());
        }
        setLocation(getX(), getY() - 1);
    }
}
