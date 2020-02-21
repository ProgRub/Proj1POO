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
    boolean control;
    
    public Exit(){
        control = false;
        imagemAtual.setTransparency(200);
    }
    public void act() 
    {
         moveMouse();
         clickMouse();
    }
    
    private void moveMouse(){

        if(!control && Greenfoot.mouseMoved(this)){
            imagemAtual.setTransparency(250);
            control = true;
        }
        if (control && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            imagemAtual.setTransparency(200);
            control = false;
        }
    }
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.stop();
        }
    }
}
