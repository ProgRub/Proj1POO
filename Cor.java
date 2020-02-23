import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cor extends Buttons
{
    private static boolean P1escolheu;
    /**
     * Act - do whatever the Cor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public static boolean getP1escolheu(){
        return P1escolheu;
    } 
    
    public static void setP1escolheu(boolean x){
        P1escolheu=x;
    }
}
