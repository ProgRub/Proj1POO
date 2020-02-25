import greenfoot.*;   //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaMáquina extends Máquina
{
   int health=Máquina.getVida();
   int healthBarComprimento = 1000;
   int healthBarAltura = 15;
   final int percentagemDeVida = (int)healthBarComprimento/health;
   
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
       myImage.setColor(Color.WHITE);
       myImage.drawRect(0,0,healthBarComprimento +1, healthBarAltura +1);
       myImage.setColor(Color.RED);
       myImage.fillRect(1,1,health*percentagemDeVida, healthBarAltura);
    }
    
    public void perdeVida(){
        health--;
}
}