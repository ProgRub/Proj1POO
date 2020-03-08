import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Menus
{
    private GreenfootImage image1, image2;
    public Play()
    {
        image1 = new GreenfootImage("Play1.png");
        image2 = new GreenfootImage("Play2.png");
    }
    
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new EscolhaNomes());
        }
    }

}
