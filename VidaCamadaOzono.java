import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaCamadaOzono extends CamadaOzono
{
   int health=CamadaOzono.getVida();
   int healthBarComprimento = 250;
   int healthBarAltura = 10;
   final int percentagemDeVida = (int)healthBarComprimento/health;
   
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
       myImage.fillRect(1,1,health*percentagemDeVida, healthBarAltura);
    }
    
    public void perdeVida(){
        health--;
}
}
