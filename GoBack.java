import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoBack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoBack extends Stage
{
    GreenfootImage image1,image2;
    
    public GoBack(){
        image1 = new GreenfootImage("goBack1.png"); //sem brilho
        image2 = new GreenfootImage("goBack2.png"); //com brilho
        setImage(image1);
    }
    public void act() 
    {
       moveMouse(image2,image1);
       clickMouse();
    }   

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if(IndividualScore.jogo1){
                Greenfoot.setWorld(new Stage1Complete());
            }
            else{
            Greenfoot.setWorld(new Stage2Complete());
        }
    }
    }  
}
