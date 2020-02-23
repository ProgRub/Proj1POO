import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Azul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Azul extends Cor
{
    /**
     * Act - do whatever the Azul wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickMouse();
    }   
    
    public Azul(){
        GreenfootImage image = new GreenfootImage(100,100);
        image.setColor(new Color(78,117,196));
        image.fillOval(0, 0, 100, 100);
        this.setImage(image);
    }
    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            if(!Cor.getP1escolheu()){
                Player1.setColor("Blue");
                Cor.setP1escolheu(true);
                getWorld().removeObject(getWorld().getObjects(Texto.class).get(0));
                getWorld().addObject(new Texto(Cor.getP1escolheu()),getWorld().getWidth()/2,getWorld().getHeight()/3);
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor("Blue");
                Greenfoot.setWorld(new Jogo1());
            }
        }
    }    
}
