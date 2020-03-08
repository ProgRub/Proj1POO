import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObjetosCaem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObjetosCaem extends Jogos
{
    /**
     * Act - do whatever the ObjetosCaem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    
    /**
     * Método que remove o objeto quando toca no "Chão"
     */
    protected void ultrapassaLimite(){
        if(isTouching(Chão.class) || getY() == getWorld().getHeight() -1){
            getWorld().removeObject(this);
        }
    }
   

    protected  void movimento() // movimento descendente
    {
        setLocation(getX()-1, getY() + 8);
    }   
}
