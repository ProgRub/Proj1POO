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
        GreenfootImage image = new GreenfootImage(text.toUpperCase(),size, cor, new Color(0,0,0,0));
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
    /**
     * Método para atualizar o texto mostrado pela classe Texto
     */
    public static void updateText(String texto, Actor text, int size, Color cor){
        GreenfootImage image = new GreenfootImage(texto.toUpperCase(),size, cor, new Color(0,0,0,0));
        text.setImage(image);
    }

}
