import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObjetosCaem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObjetosCaem extends Actor
{
    /**
     * Act - do whatever the ObjetosCaem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    protected void ultrapassaLimite(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

    protected  void movimento(){
        setLocation(getX()-1, getY() + 8);
    }   
}
