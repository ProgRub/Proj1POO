import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Menus
{
    private GreenfootImage image1, image2;
    public Restart()
    {
        image1 = new GreenfootImage("RESTART (1).png");
        image2 = new GreenfootImage("RESTART.png");
    }
    public void act() 
    {
        moveMouse(image1,image2);
        clickMouse();
    }   
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuInicial(false));
        }
    }    
}   
