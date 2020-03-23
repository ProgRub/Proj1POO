import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menus extends Objetos
{
    private GreenfootSound click;
    public Menus()
    {
        click = new GreenfootSound("click.mp3");
    }
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
    
    /** 
     * Método para tocar um som de "click" quando os botões são pressionados
     */
    protected void playClick()
    {
        click.play();
        click.setVolume(50);
    }
}
