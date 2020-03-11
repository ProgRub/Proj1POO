import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vermelho here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vermelho extends Cor
{  
    public Vermelho(){
        GreenfootImage image = new GreenfootImage(125,125);
        image.setColor(new Color(149,19,23));
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
                Player1.setColor("Red");
                Cor.setP1escolheu(true);
                Options.updateText(Player2.getNome()+",\npick your colour", getWorld().getObjects(Texto.class).get(0), 60, new Color(255,255,255));
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor("Red");
                Greenfoot.setWorld(new HowToPlay());
            }
        }
    }
}
