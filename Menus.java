import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menus extends Objetos
{
    public void act() 
    {
    }    

    /**
     * Método para alterar a imagem consoante o rato passa por cima do botão
     */
    protected void moveMouse(GreenfootImage image1, GreenfootImage image2){
        if(Greenfoot.mouseMoved(this)){
            setImage(image1);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(image2);
        }
    }    
}
