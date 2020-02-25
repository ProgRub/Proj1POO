import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_player2 extends Player2
{
    /**
     * Act - do whatever the Vida_player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage dez, nove, oito, sete, seis, cinco, quatro, tres, dois, um;
    private Player2 P2=null;
    private Nave2 N2=null;

    public Vida_player2(Player2 player)
    {
        dez = new GreenfootImage("Vida/10.png");
        nove = new GreenfootImage("Vida/9.png");
        oito = new GreenfootImage("Vida/8.png");
        sete = new GreenfootImage("Vida/7.png");
        seis = new GreenfootImage("Vida/6.png");
        cinco = new GreenfootImage("Vida/5.png");
        quatro = new GreenfootImage("Vida/4.png");
        tres = new GreenfootImage("Vida/3.png");
        dois = new GreenfootImage("Vida/2.png");
        um = new GreenfootImage("Vida/1.png");
        setImage(dez);
        P2=player;
    }

    public Vida_player2(Nave2 player)
    {
        dez = new GreenfootImage("Vida/10.png");
        nove = new GreenfootImage("Vida/9.png");
        oito = new GreenfootImage("Vida/8.png");
        sete = new GreenfootImage("Vida/7.png");
        seis = new GreenfootImage("Vida/6.png");
        cinco = new GreenfootImage("Vida/5.png");
        quatro = new GreenfootImage("Vida/4.png");
        tres = new GreenfootImage("Vida/3.png");
        dois = new GreenfootImage("Vida/2.png");
        um = new GreenfootImage("Vida/1.png");
        setImage(dez);
        N2=player;
    }
    public void act() 
    {
        if(P2!=null)
        {
            vidaPlayer2(P2);
        }
        else
        {
            vidaPlayer2(N2);
        }
    }   
    
       

    public void vidaPlayer2(Player2 P2)
    {
        if (P2.getNumeroVidas() == 10)
        {
            setImage(dez);
        }
        else if(P2.getNumeroVidas() == 9){
            setImage(nove);
        }
        else if(P2.getNumeroVidas() == 8){
            setImage(oito);
        }
        else if(P2.getNumeroVidas() == 7){
            setImage(sete);
        }
        else if(P2.getNumeroVidas() == 6){
            setImage(seis);
        }
        else if(P2.getNumeroVidas() == 5){
            setImage(cinco);
        }
        else if(P2.getNumeroVidas() == 4){
            setImage(quatro);
        }
        else if(P2.getNumeroVidas() == 3){
            setImage(tres);
        }
        else if(P2.getNumeroVidas() == 2){
            setImage(dois);
        }
        else if(P2.getNumeroVidas() == 1){
            setImage(um);
        }
        else if(P2.getNumeroVidas() <= 0){
            getWorld().removeObject(this);
        }    
    }   

    public void vidaPlayer2(Nave2 P2)
    {
        if (P2.getNumeroVidas() == 10)
        {
            setImage(dez);
        }
        else if(P2.getNumeroVidas() == 9){
            setImage(nove);
        }
        else if(P2.getNumeroVidas() == 8){
            setImage(oito);
        }
        else if(P2.getNumeroVidas() == 7){
            setImage(sete);
        }
        else if(P2.getNumeroVidas() == 6){
            setImage(seis);
        }
        else if(P2.getNumeroVidas() == 5){
            setImage(cinco);
        }
        else if(P2.getNumeroVidas() == 4){
            setImage(quatro);
        }
        else if(P2.getNumeroVidas() == 3){
            setImage(tres);
        }
        else if(P2.getNumeroVidas() == 2){
            setImage(dois);
        }
        else if(P2.getNumeroVidas() == 1){
            setImage(um);
        }
        else if(P2.getNumeroVidas() <= 0){
            getWorld().removeObject(this);
        }    
    }
}
