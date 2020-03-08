import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)	

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Menus
{
    public void act() 
    {
        moveMouse();
        clickMouse();
    }   

    /**
     * Método para alterar a imagem consoante o rato passa por cima do botão
     */
    private void moveMouse(){
        if(Greenfoot.mouseMoved(this)){
            setImage("BackComBrilho.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage("BackSemBrilho.png");
        }
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
