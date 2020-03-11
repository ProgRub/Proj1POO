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
    
    /**
     * Método para as subclasses desta classe, para os botões relacionados com a mudança de controlos
     */
    public void moveMouseBotaoControlos(){
        if(Greenfoot.mouseMoved(this)){
            setImage("BotaoControlos2.png");
            getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("BotaoControlos.png");
            getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        }
    }
    
    /**
     * Método para atualizar o texto mostrado pela classe Texto
     */
    public static void updateText(String texto, Actor text, int size, Color cor){
        GreenfootImage image = new GreenfootImage(texto.toUpperCase(),size, cor, new Color(0,0,0,0));
        text.setImage(image);
    }
}