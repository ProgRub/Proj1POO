import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Buttons
{

    public void act() 
    {
        moveMouse();
        clickMouse();
    }

    public void moveMouse(){

        if(Greenfoot.mouseMoved(this)){
            setImage("OptionsComBrilho.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("Options2.png");
        }
    }

    public void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Opções());
        }
    }
}