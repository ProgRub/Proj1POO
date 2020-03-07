import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaCamadaOzono extends CamadaOzono
{
   private int health = CamadaOzono.getVida();
   private int healthBarComprimento = 250;
   private int healthBarAltura = 10;
   private final int percentagemDeVida = (int)healthBarComprimento/health;
   
   public VidaCamadaOzono(){
       atualiza();
    }
    
   public void act() 
    {
        atualiza();
    }    
    
   /**
    * Método que atualiza a healthbar que mostra ao jogador quanta vida a camada de ozono tem
    */
   private void atualiza(){
       setImage(new GreenfootImage(healthBarComprimento + 2, healthBarAltura + 2));
       GreenfootImage myImage = getImage();
       health=CamadaOzono.getVida();
       myImage.setColor(Color.BLACK);
       myImage.drawRect(0,0,healthBarComprimento +1, healthBarAltura +1);
       myImage.setColor(Color.CYAN);
       myImage.fillRect(1,1,health*percentagemDeVida, healthBarAltura);
    }
}
