import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Options
{
    private Color Cor;

    public Texto(){}

    public Texto(String text, int size , Color cor){
        GreenfootImage image = new GreenfootImage(text,size, cor, new Color(0,0,0,0));
        setImage(image);
        Cor=cor;
    }

    public void act()
    {

    }

    public Color getCor()
    {
        return Cor;
    }

}
