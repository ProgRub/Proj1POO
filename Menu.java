import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Stage
{
    private GreenfootImage image1,image2;
    
    public Menu(){
        image1 = new GreenfootImage("close1.png"); //sem brilho
        image2 = new GreenfootImage("close.png"); //com brilho
        setImage(image1);
    }
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }   

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuInicial(false));
            // Player1.setColor("Red");
            // Player2.setColor("Red");
            // Greenfoot.setWorld(new Jogo2());
        }
    }  
}
