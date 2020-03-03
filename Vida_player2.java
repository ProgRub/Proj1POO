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
    private GreenfootImage dez, nove, oito, sete, seis, cinco, quatro, tres, dois, um;
    private Player2 P2=null;

    public Vida_player2()
    {
        dez = new GreenfootImage("Vida/10.png");
        dez.mirrorHorizontally();
        nove = new GreenfootImage("Vida/9.png");
        nove.mirrorHorizontally();
        oito = new GreenfootImage("Vida/8.png");
        oito.mirrorHorizontally();
        sete = new GreenfootImage("Vida/7.png");
        sete.mirrorHorizontally();
        seis = new GreenfootImage("Vida/6.png");
        seis.mirrorHorizontally();
        cinco = new GreenfootImage("Vida/5.png");
        cinco.mirrorHorizontally();
        quatro = new GreenfootImage("Vida/4.png");
        quatro.mirrorHorizontally();
        tres = new GreenfootImage("Vida/3.png");
        tres.mirrorHorizontally();
        dois = new GreenfootImage("Vida/2.png");
        dois.mirrorHorizontally();
        um = new GreenfootImage("Vida/1.png");
        um.mirrorHorizontally();

    }

    public void act() 
    {
        vidaPlayer2(P2);
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

}
