import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Preto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Preto extends Cor
{    
    public Preto(){
        GreenfootImage image = new GreenfootImage(125,125);
        image.setColor(new Color(55,55,57));
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
                Player1.setColor("Black");
                Cor.setP1escolheu(true);
                Texto.updateText(Player2.getNome()+",\npick your colour", getWorld().getObjects(Texto.class).get(0), 60, new Color(255,255,255));
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor("Black");
                Greenfoot.setWorld(new HowToPlay());
            }
        }
    }   
}
