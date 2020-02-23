import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Options
{
    /**
     * Act - do whatever the Texto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public Texto(){}
    
    public Texto(int qualPlayer){
        GreenfootImage image = new GreenfootImage("Player " + Integer.toString(qualPlayer),50, Color.WHITE, new Color(0,0,0,0));
        setImage(image);
    }
    
    public Texto(boolean P1escolheu){
        if(!P1escolheu){
            updateText("Player 1, pick your color",this,60);
        }
        else{
            updateText("Player 2, pick your color",this,60);
        }
    }
}
