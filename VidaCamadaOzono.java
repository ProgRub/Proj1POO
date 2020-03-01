import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaCamadaOzono extends CamadaOzono
{
   private final int healthBarComprimento = 250;
   private final int healthBarAltura = 10;
   final int percentagemDeVida = (int)healthBarComprimento/CamadaOzono.getVida();
   
   public VidaCamadaOzono(){
       atualiza();
    }
    
   public void act() 
    {
        atualiza();
    }    
    
   public void atualiza(){
       setImage(new GreenfootImage(healthBarComprimento + 2, healthBarAltura + 2));
       GreenfootImage myImage = getImage();
       myImage.setColor(Color.BLACK);
       myImage.drawRect(0,0,healthBarComprimento +1, healthBarAltura +1);
       myImage.setColor(Color.CYAN);
       myImage.fillRect(1,1,CamadaOzono.getVida()*percentagemDeVida, healthBarAltura);
    }
}
