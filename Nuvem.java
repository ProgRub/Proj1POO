import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nuvem extends Jogos
{
    private int aux;
    private int sentido;
    
    public Nuvem(int sentidoMovimento)
    {
        aux=0;
        sentido=sentidoMovimento;
       
    }
    
    public void act() 
    {
        movimentoNuvem(sentido);
    }  
    
    /**
     * Método que movimenta a nuvem
     */
    private void movimentoNuvem(int sentido){
        if (aux<105)
        {
            move(sentido*3);
           
        }
        if (Greenfoot.getRandomNumber(100)<2 && aux>=105){
            setLocation(getX()+ Greenfoot.getRandomNumber(20)-10, getY());
        }
        aux++;
          
    }
    
}
