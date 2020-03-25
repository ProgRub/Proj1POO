import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mar extends Jogos
{
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
