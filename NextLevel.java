import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevel extends Stage
{
    private GreenfootImage image1,image2;
    
    public NextLevel(){
        image1 = new GreenfootImage("nextLevel1.png"); //sem brilho
        image2 = new GreenfootImage("nextLevel.png"); //com brilho
        setImage(image1);
    }
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }   

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if (getWorld() instanceof Stage1Complete){
              Greenfoot.setWorld(new Jogo2());
            }else if(getWorld() instanceof Stage2Complete){
              Greenfoot.setWorld(new Jogo3());
            } 
        }
    }    
}
