import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Azul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Azul extends Cor
{   
    
    public Azul(){
        GreenfootImage image = new GreenfootImage(125,125);
        image.setColor(new Color(6,118,189));
        image.fillOval(0, 0, 125, 125);
        this.setImage(image);
    }
    
    public void act() 
    {
        clickMouse();
    }
    
    /**
     * Método que regista a cor que os jogadores escolheram e atualiza as variáveis e o mundo de acordo
     */    
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            playClick();
            if(!Cor.getP1escolheu()){
                Player1.setColor("Blue");
                Cor.setP1escolheu(true);
                Texto.updateText(Player2.getNome()+",\npick your colour", getWorld().getObjects(Texto.class).get(0), 60, new Color(255,255,255));
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor("Blue");
                Greenfoot.setWorld(new HowToPlay());
            }
        }
    }    
}
