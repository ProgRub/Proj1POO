import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartLevel extends Stage
{
    GreenfootImage image1,image2;
    
    public RestartLevel(){
        image1 = new GreenfootImage("replay1.png"); //sem brilho
        image2 = new GreenfootImage("replay.png"); //com brilho
    }
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }   

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if (getWorld() instanceof Jogo1){
              Greenfoot.setWorld(new Jogo1());
            }else if (getWorld() instanceof Jogo2){
                Greenfoot.setWorld(new Jogo2());
            }else if (getWorld() instanceof Jogo3){
                Greenfoot.setWorld(new Jogo3());
            }
            // Player1.setColor("Red");
            // Player2.setColor("Red");
            // Greenfoot.setWorld(new Jogo2());
        }
    }     
}
