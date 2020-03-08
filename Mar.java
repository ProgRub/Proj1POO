import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mar extends Jogos
{
    /**
     * Act - do whatever the Mar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-1);
        remove();
    }  
    
    /**
     * Método que remove o objeto quando chega ao limite do mundo
     */
    private void remove()
    {
        if (isAtEdge()){
            getWorld().removeObject(this);
    }
}
}
