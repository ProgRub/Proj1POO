import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Start extends Menus
{
    private GreenfootImage image1,image2;
    public Start(){
        image1 = new GreenfootImage("StartSemBrilho.png");
        image2 = new GreenfootImage("StartComBrilho.png");
        setImage(image1);
    }

    public void act() 
    {
        moveMouse(image2,image1);
        clickMouse();
    }  

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            playClick();
            MenuInicial.getMusica().stop(); 
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
