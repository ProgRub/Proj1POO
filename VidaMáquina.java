import greenfoot.*;   //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaMáquina extends Máquina
{
   private int health = Máquina.getVida();
   private final int HEALTHBARCOMPRIMENTO = 1000;
   private final int HEALTHBARALTURA = 15;
   private final int percentagemDeVida = (int)HEALTHBARCOMPRIMENTO/health;
   
   public VidaMáquina(){
       //atualiza();
    }
    
   public void act() 
    {
        atualiza();
    }    
    
   /**
    * Método que atualiza a barra de vida que informa os jogadores quanta vida a máquina tem
    */
   public void atualiza(){
       setImage(new GreenfootImage(HEALTHBARCOMPRIMENTO + 2, HEALTHBARALTURA + 2));
       GreenfootImage myImage = getImage();
       health=Máquina.getVida();
       myImage.setColor(Color.WHITE);
       myImage.drawRect(0,0,HEALTHBARCOMPRIMENTO +1, HEALTHBARALTURA +1);
       myImage.setColor(new Color(109, 16, 120));
       myImage.fillRect(1,1,health * percentagemDeVida, HEALTHBARALTURA);
    }
}