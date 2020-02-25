import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage extends Menus
{
    public void act() 
    {
    }   

    public void moveMouse(GreenfootImage image1, GreenfootImage image2){
        if(Greenfoot.mouseMoved(this)){
            setImage(image1);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(image2);
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
