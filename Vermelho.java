import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vermelho here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vermelho extends Cor
{
    /**
     * Act - do whatever the Vermelho wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickMouse();
    }   

    public Vermelho(){
        GreenfootImage image = new GreenfootImage(100,100);
        image.setColor(new Color(174,87,87));
        image.fillOval(0, 0, 100, 100);
        this.setImage(image);
    }

    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if(!Cor.getP1escolheu()){
                Player1.setColor("Red");
                Cor.setP1escolheu(true);
                getWorld().removeObject(getWorld().getObjects(Texto.class).get(0));
                getWorld().addObject(new Texto(Cor.getP1escolheu()),getWorld().getWidth()/2,getWorld().getHeight()/3);
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor("Red");
                MenuInicial.getMusica().stop();
                Greenfoot.setWorld(new Jogo1());
            }
        }
    }
}
