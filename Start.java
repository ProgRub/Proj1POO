import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Continue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Stage
{
    private GreenfootImage image1,image2;
    public Start(){
        image1 = new GreenfootImage("START.png"); //sem brilho
        image2 = new GreenfootImage("START (1).png"); //com brilho
        setImage(image1);
    }
    
    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }  
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if (getWorld() instanceof HowToPlay){
                if(HowToPlay.jogoAtual() == 1){
                    Greenfoot.setWorld(new Jogo1());
                }else if(HowToPlay.jogoAtual() == 2){
                    Greenfoot.setWorld(new Jogo2());
                }else if(HowToPlay.jogoAtual() == 3){
                    Greenfoot.setWorld(new Jogo3());
                }
            } 
        }
    } 
}
