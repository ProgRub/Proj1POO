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
        setImage(image1);
    }

    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }

    /**
     * Métodos que registam que o rato clicou no botão ou o utilizador carregou no Esc e, neste caso, volta ao mundo anterior
     */
    private void clickMouse(){
        String key =Greenfoot.getKey();
        World mundo = getWorld();
        if (Greenfoot.mouseClicked(this) || (key!=null && key.equals("escape"))){
            playClick();
            Greenfoot.setWorld(new MenuInicial(false));
        }
        key = null;
        mundo = null;
    }  
}
