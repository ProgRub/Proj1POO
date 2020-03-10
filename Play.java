import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
