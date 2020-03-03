import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayersScore extends Stage
{
    private GreenfootImage image1,image2;
    
    public PlayersScore(){
        image1 = new GreenfootImage("playersScore1.png"); //sem brilho
        image2 = new GreenfootImage("playersScore.png"); //com brilho
        setImage(image1);
    }
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }   

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
              Greenfoot.setWorld(new IndividualScore());
        }
    }     
}
