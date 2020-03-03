import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Relâmpago here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Relâmpago extends Target
{
    /**
     * Act - do whatever the Relâmpago wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    private GreenfootImage[] relampago= new GreenfootImage[4];
    private int indice=0;

    private int count;
    private final int TIMER;
    private int count2;
    private int wait;
    private GreenfootSound somRelampago;
    public Relâmpago()
    {
        somRelampago = new GreenfootSound ("relampago.mp3");
        relampago[0] = new GreenfootImage("Lightning/1.png");
        relampago[1] = new GreenfootImage("Lightning/2.png");
        relampago[2] = new GreenfootImage("Lightning/3.png");
        relampago[3] = new GreenfootImage("Lightning/4.png");
        setImage(relampago[indice]);
        indice++;
        somRelampago.play();
        TIMER=8;
        count = 0;
    }

    public void act() 
    {
        switchImage();
    }

    public void switchImage()
    {
        if (count%TIMER==0){
            setImage(relampago[indice]);
            indice++;
            if (indice >= relampago.length)
            {
                getWorld().removeObject(this);
            }
        }  
        count++;     
    }
    
    public void removerRelampago(){

        if(count <= 0){
            getWorld().removeObject(this);
        }
        count--;
    }
}
