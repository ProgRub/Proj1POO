import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Buttons
{
    private GreenfootImage imagemAtual = getImage();
    private GreenfootImage semBrilho, comBrilho;
    boolean control;
    
    public Exit(){
        control = false;
        semBrilho = new GreenfootImage("EXITsem.png");
        comBrilho = new GreenfootImage("EXITcom.png");
    }
    public void act() 
    {
         moveMouse();
         clickMouse();
    }
    
    private void moveMouse(){

        if(!control && Greenfoot.mouseMoved(this)){
            setImage("EXITcom.png");
            control = true;
        }
        if (control && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("EXITsem.png");
            control = false;
        }
    }
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.stop();
        }
    }
}
