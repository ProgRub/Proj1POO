import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Preto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Preto extends Cor
{
    /**
     * Act - do whatever the Preto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickMouse();
    }    
    
    public Preto(){
        GreenfootImage image = new GreenfootImage(100,100);
        image.setColor(new Color(88,88,88));
        image.fillOval(0, 0, 100, 100);
        this.setImage(image);
    }    
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if(!Cor.getP1escolheu()){
                Player1.setColor("Black");
                Cor.setP1escolheu(true);
                Options.updateText(Player2.getNome()+", PICK YOUR COLOUR", getWorld().getObjects(Texto.class).get(0), 60, new Color(255,255,255));
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor("Black");
                MenuInicial.getMusica().stop();
                Greenfoot.setWorld(new Jogo1());
            }
        }
    }   
}
