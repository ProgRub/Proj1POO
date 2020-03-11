import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Menus
{
    private GreenfootImage image1, image2;
    public Options()
    {
        image1 = new GreenfootImage("OptionsSemBrilho.png");
        image2 = new GreenfootImage("OptionsComBrilho.png");
    }
    
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }
    
    public void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            playClick();
            Greenfoot.setWorld(new Opções());
        }
    }
}