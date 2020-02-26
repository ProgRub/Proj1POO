import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Jogos
{
    GreenfootImage pisca1, pisca2;
    private int contador;
    public GameOver(){
        pisca1 = new GreenfootImage("GM1.png");
        pisca2 = new GreenfootImage("gm2.png");
        setImage(pisca1);
        contador = 0;
    }
    
    public void act() 
    {
        pisca();
    }  
    
    public void pisca(){
        contador++;

        if (contador==10){
           if(getImage()==pisca1){
               setImage(pisca2);
           }
           else if (getImage()==pisca2){
               setImage(pisca1);
           }
            contador=0;
        }
    }
}
