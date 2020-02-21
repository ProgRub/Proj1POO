import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Relâmpago here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Relâmpago extends Actor
{
    int alturaAtual, larguraAtual;
    public Relâmpago(){
         setImage("thunder1.png");
         //GreenfootImage imagemAtual = getImage();
         //alturaAtual = imagemAtual.getHeight();
        // larguraAtual = imagemAtual.getWidth();
        //imagemAtual.scale(larguraAtual,alturaAtual*2);
    }
    public void act() 
    {
        Greenfoot.delay(1);
        setImage("thunder2.png");
        Greenfoot.delay(1);
        setImage("thunder3.png");
        Greenfoot.delay(1);
        setImage("thunder4.png");
        Greenfoot.delay(1);
        setImage("thunder5.png");
        Greenfoot.delay(1);
        setImage("thunder6.png");
        Greenfoot.delay(1);
        getWorld().removeObject(this);
        
    }
}
