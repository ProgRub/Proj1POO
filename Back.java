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
     * Método que regista que o rato clicou no botão e, neste caso, cria um mundo MenuInicial sem fazer reset dos controlos
     */
    private void clickMouse(){
        String key =Greenfoot.getKey();
        World mundo = getWorld();
        if (Greenfoot.mouseClicked(this) || (key!=null && key.equals("escape"))){
            if (mundo instanceof Opções || mundo instanceof EscolhaNomes)
            {
                Greenfoot.setWorld(new MenuInicial(false));
            }
            else if (mundo instanceof EscolherCor)
            {
                Greenfoot.setWorld(new EscolhaNomes());
            }
        }
        key = null;
        mundo = null;
    } 
    public void clickMouse(String key){
        World mundo = getWorld();
        if (Greenfoot.mouseClicked(this) || (key.equals("escape"))){
            if (mundo instanceof Opções || mundo instanceof EscolhaNomes)
            {
                Greenfoot.setWorld(new MenuInicial(false));
            }
            else if (mundo instanceof EscolherCor)
            {
                Greenfoot.setWorld(new EscolhaNomes());
            }
        }
        key = null;
        mundo = null;
    }   
}
