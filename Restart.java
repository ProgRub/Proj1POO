import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Menus
{
    
    public void act() 
    {
        moveMouse();
        clickMouse();
    }   

    public void moveMouse(){
        if(Greenfoot.mouseMoved(this)){
            setImage("RESTART (1).png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("RESTART.png");
        }
    }

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuInicial(false));
        }
    }    
}   
