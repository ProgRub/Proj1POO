import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Buttons
{
    private GreenfootImage semBrilho, comBrilho;
    protected boolean control;
    
    public Play(){
        semBrilho = new GreenfootImage("Play1.png");
        comBrilho = new GreenfootImage("Play2.png");
        control = false;
    }
    
    public void act() 
    {
        moveMouse();
        clickMouse();
    }   
    
    public void moveMouse(){
        if(!control && Greenfoot.mouseMoved(this)){
            setImage(comBrilho);
            control = true;
        }
        if (control && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(semBrilho);
            control = false;
        }
    }
    
    private void clickMouse(){

        if (Greenfoot.mouseClicked(this)){
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Jogo1());
        }
    }
        
}
