import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Máquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Máquina extends Actor
{
    /**
     * Act - do whatever the Máquina wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        libertGas();
    }   
    
    public void libertGas(){
        if (Greenfoot.getRandomNumber(100)>97){
        Máquina maq = getWorld().getObjects(Máquina.class).get(0);
        getWorld().addObject(new Gas(),maq.getX()+Greenfoot.getRandomNumber(40)-10, maq.getY() - maq.getImage().getHeight()/2);
    }
    }  
}
