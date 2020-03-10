import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Relâmpago here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Relâmpago extends Target
{
    private GreenfootImage[] relampago;
    private int indice=0;
    private int count;
    private final int TIMER;
    private GreenfootSound somRelampago;
    public Relâmpago()
    {
        somRelampago = new GreenfootSound ("relampago.mp3");
        relampago= new GreenfootImage[3];
        for (int i=0; i < relampago.length; i++)
        {
            relampago[i] = new GreenfootImage("Lightning/"+(i+1)+".png");
            relampago[i].scale(3*relampago[i].getWidth()/4,relampago[i].getHeight());
        }
        setImage(relampago[indice]);
        indice++;
        somRelampago.play();
        somRelampago.setVolume(50);
        TIMER=8;
        count = 0;
    }

    public void act() 
    {
        switchImage();
    }

    /**
     * Método que anima o relâmpago
     */
    public void switchImage()
    {
        if (count%TIMER==0){
            if (count < TIMER*relampago.length)
            {
                setImage(relampago[indice]);
                indice++;
                if (indice >= relampago.length)
                {
                    indice=0;
                }
            }
            else
            {
                getWorld().removeObject(this);
            }
        }  
        count++;     
    }
}
