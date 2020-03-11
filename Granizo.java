import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Granizo extends ObjetosCaem
{
    /**
     * Act - do whatever the Granizo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageGranizo;
    public Granizo()

    {
        imageGranizo = getImage();
        imageGranizo.scale(imageGranizo.getWidth()/3, imageGranizo.getHeight()/3);
    }

    public void act() 
    {
        movimento();
        ultrapassaLimite();
    }  
}
