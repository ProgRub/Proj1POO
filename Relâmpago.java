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
    private GreenfootImage target;

    private int count;
    private final int TIMER;
    private int count2;
    private int wait;
    private GreenfootSound somRelampago;
    public Relâmpago()
    {
        somRelampago = new GreenfootSound ("relampago.mp3");
        image1 = new GreenfootImage("Lightning/1.png");
        image2 = new GreenfootImage("Lightning/2.png");
        image3 = new GreenfootImage("Lightning/3.png");
        image4 = new GreenfootImage("Lightning/4.png");
        setImage(image1);
        somRelampago.play();
        TIMER=5;
        count = TIMER*4;
        count2 = 0;
    }

    public void act() 
    {
        switchImage();
        removerRelampago();
    }

    public void switchImage()
    {
        if (count2%TIMER==0){
            if (getImage() == image1)
            {
                setImage(image2);
            }

            else if (getImage() == image2)
            {
                setImage(image3);
            }

            else if (getImage() == image3)
            {
                setImage(image4);
            }

            else if (getImage() == image4)
            {
                setImage(image1);

            }
        }  
        count2++;     
    }
    
    public void removerRelampago(){

        if(count <= 0){
            getWorld().removeObject(this);
        }
        count--;
    }
}
