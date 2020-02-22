import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Buttons
{
    public void act() 
    {
        moveMouse();
        clickMouse();
    }

    private void moveMouse(){

        if(Greenfoot.mouseMoved(this)){
            setImage("EXITcom.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("EXITsem.png");
        }
    }

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.stop();
        }
    }
}
