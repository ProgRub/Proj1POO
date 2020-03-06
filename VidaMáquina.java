import greenfoot.*;   //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaMáquina extends Máquina
{
   private int health=Máquina.getVida();;
   private int healthBarComprimento = 1000;
   private int healthBarAltura = 15;
   private final int percentagemDeVida = (int)healthBarComprimento/health;
   
   public VidaMáquina(){
       atualiza();
    }
    
   public void act() 
    {
        atualiza();
    }    
    
   public void atualiza(){
       setImage(new GreenfootImage(healthBarComprimento + 2, healthBarAltura + 2));
       GreenfootImage myImage = getImage();
       health=Máquina.getVida();
       myImage.setColor(Color.WHITE);
       myImage.drawRect(0,0,healthBarComprimento +1, healthBarAltura +1);
       myImage.setColor(new Color(109, 16, 120));
       myImage.fillRect(1,1,health*percentagemDeVida, healthBarAltura);
    }
}