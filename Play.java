import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Menus
{

    public void act() 
    {
        moveMouse();
        clickMouse();
    }   

    public void moveMouse(){
        if(Greenfoot.mouseMoved(this)){
            setImage("Play2.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("Play1.png");
        }
    }

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new EscolherCor());
            // Player1.setColor("Red");
            // Player2.setColor("Red");
            // Greenfoot.setWorld(new Jogo2());
        }
    }

}
