import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Buttons
{
    public void act() 
    {
        moveMouse();
        clickMouse();
    }   

    public void moveMouse(){
        if(Greenfoot.mouseMoved(this)){
            setImage("BackComBrilho.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("BackSemBrilho.png");
        }
    }

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(Opções.getMenu());
        }
    }    
}
