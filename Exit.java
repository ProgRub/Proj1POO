import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Menus
{
    private GreenfootImage image1, image2;
    public Exit()
    {
        image1 = new GreenfootImage("EXITsem.png");
        image2 = new GreenfootImage("EXITcom.png");
    }
    
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }

    private void clickMouse(){
        String key = Greenfoot.getKey();
        if (Greenfoot.mouseClicked(this) || (key!=null && key.equals("escape"))){
            MenuInicial.getMusica().stop();
            Greenfoot.stop();
        }
        key=null;
    }
}
