import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_player1 extends Player1
{
    /**
     * Act - do whatever the Vida_player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage dez, nove, oito, sete, seis, cinco, quatro, tres, dois, um;
    
    public Vida_player1()
    {
        
        dez = new GreenfootImage("10_.png");
        nove = new GreenfootImage("9.png");
        oito = new GreenfootImage("8.png");
        sete = new GreenfootImage("7.png");
        seis = new GreenfootImage("6.png");
        cinco = new GreenfootImage("5.png");
        quatro = new GreenfootImage("4.png");
        tres = new GreenfootImage("3.png");
        dois = new GreenfootImage("2.png");
        um = new GreenfootImage("1.png");
        setImage(dez);
    }
    public void act() 
    {
        vidaPlayer1();
    }   
    
    public void vidaPlayer1()
    {
        if (Player1.numeroVidas == 10)
        {
            setImage(dez);
        }
        else if(Player1.numeroVidas == 9){
            setImage(nove);
        }
        else if(Player1.numeroVidas == 8){
            setImage(oito);
        }
        else if(Player1.numeroVidas == 7){
            setImage(sete);
        }
        else if(Player1.numeroVidas == 6){
            setImage(seis);
        }
        else if(Player1.numeroVidas == 5){
            setImage(cinco);
        }
        else if(Player1.numeroVidas == 4){
            setImage(quatro);
        }
        else if(Player1.numeroVidas == 3){
            setImage(tres);
        }
        else if(Player1.numeroVidas == 2){
            setImage(dois);
        }
        else if(Player1.numeroVidas == 1){
            setImage(um);
        }
        else if(Player1.numeroVidas == 0){
            getWorld().removeObject(this);
    }
    
        
    
    }
}
