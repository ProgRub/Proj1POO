import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cor extends Menus
{
    private static boolean P1escolheu;
    public void act() 
    {
    } 
    
    public static boolean getP1escolheu(){
        return P1escolheu;
    } 
    
    public static void setP1escolheu(boolean x){
        P1escolheu=x;
    }
}
