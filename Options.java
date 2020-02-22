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
            Greenfoot.setWorld(new Opções());
        }
    }
    
    public void moveMouseBotaoControlos(){
        if(Greenfoot.mouseMoved(this)){
            setImage("BotaoControlos2.png");
            getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("BotaoControlos.png");
            getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        }
    }
}