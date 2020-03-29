import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gota extends ObjetosCaem
{
    public void act() 
    {
        movimento();
        ultrapassaLimite();
    }       
    
    protected void ultrapassaLimite(){
        if(isTouching(Chão.class) || isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
