import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Buttons
{
    
    private GreenfootImage imagemAtual = getImage();
    private GreenfootImage semBrilho, comBrilho;
    boolean control;
    
    public Options(){
        control = false;
        semBrilho = new GreenfootImage("OptionsComBrilho.png");
        comBrilho = new GreenfootImage("Options2.png");
    }
    public void act() 
    {
         moveMouse();
         clickMouse();
    }
    
    private void moveMouse(){

        if(!control && Greenfoot.mouseMoved(this)){
            setImage("OptionsComBrilho.png");
            control = true;
        }
        if (control && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("Options2.png");
            control = false;
        }
    }
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Opções());
        }
    }
}