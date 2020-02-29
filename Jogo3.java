import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo3 extends World
{

    /**
     * Constructor for objects of class Jogo3.
     * 
     */
    
    private int contador;

    public Jogo3()
    {    
        super(1200, 700, 1); 
        contador=0;
        prepare();   
    }

    public void act(){
        invocarPlataformas();
        invocarMar();
    }

    public void invocarPlataformas() 
    {
        if (Greenfoot.getRandomNumber(500)<3)
        {
            addObject(new PlataformaGelo(),getWidth()-1,Greenfoot.getRandomNumber(getHeight() -1));
        }
    }

    public void invocarMar(){
        contador++;
        if(contador == 200){
            addObject(new Mar(),getWidth()-10,getHeight() -30);
            contador=0;
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Mar mar = new Mar();
        addObject(mar,603,getHeight() -30);
        Mar mar2 = new Mar();
        addObject(mar2,1012,getHeight() -30);
    }
}

