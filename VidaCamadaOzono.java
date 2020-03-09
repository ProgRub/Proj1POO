import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaCamadaOzono extends CamadaOzono
{
   private int health = CamadaOzono.getVida();
   private final int HEALTHBARCOMPRIMENTO = 250;
   private final int HEALTHBARALTURA = 10;
   private final int percentagemDeVida = (int)HEALTHBARCOMPRIMENTO/health;
   
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
       setImage(new GreenfootImage(HEALTHBARCOMPRIMENTO + 2, HEALTHBARALTURA + 2));
       GreenfootImage myImage = getImage();
       health=CamadaOzono.getVida();
       myImage.setColor(Color.BLACK);
       myImage.drawRect(0,0,HEALTHBARCOMPRIMENTO +1, HEALTHBARALTURA +1);
       myImage.setColor(Color.CYAN);
       myImage.fillRect(1,1,health*percentagemDeVida, HEALTHBARALTURA);
    }
}
