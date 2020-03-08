import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Jogos
{
    private int count;
    private final int TIMER;
    private int count2;
    private GreenfootImage semBrilho,comBrilho;
    
    private int contador;
    public Target(){
        semBrilho = new GreenfootImage("targetf.png");
        comBrilho = new GreenfootImage("target8.png");
        setImage(semBrilho);
        TIMER=5;
        count = TIMER*4;
        count2 = 0;
        contador=0;
    }
    
    public void act() 
    {
        switchImage();
        conta(this);
    }
    
    public void switchImage()
    {
        if (count2%TIMER==0){
            if (getImage() == semBrilho)
            {
                setImage(comBrilho);
            }

            else if (getImage() == comBrilho)
            {
                setImage(semBrilho);
            }
        }  
        count2++;     
    }
    
    /**
     * Método que faz a contagem para remover o objeto do mundo e adicionar um novo objeto da classe "Relâmpago"
     * (permite "dar tempo" aos jogadores para se afastarem do relâmpago)
     */
    private void conta(Target target)
    {  
        contador++;
        if(contador == 140)
        {
           getWorld().addObject(new Relâmpago(), target.getX(),320);
           getWorld().removeObject(target);
           contador = 0;
        }
    }
}
