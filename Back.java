import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)	

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Menus
{
    private GreenfootImage image1, image2;
    public Back()
    {
        image1 = new GreenfootImage("BackSemBrilho.png");
        image2 = new GreenfootImage("BackComBrilho.png");
    }
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }

    /**
     * Método que regista que o rato clicou no botão e, neste caso, cria um mundo MenuInicial sem fazer reset dos controlos
     */
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuInicial(false));
        }
    }    
}
