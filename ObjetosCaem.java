import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ObjetosCaem extends Jogos
{
    public void act() 
    {
    } 
    
    /**
     * Método que remove o objeto quando toca no "Chão"
     */
    protected void ultrapassaLimite(){
        if(isTouching(Chão.class) || getY() == getWorld().getHeight() -1){
            getWorld().removeObject(this);
        }
    }

    /**
     * Método que movimenta todos os objetos que "caem"
     */
    protected  void movimento()
    {
        setLocation(getX()-1, getY() + 8);
    }   
}
