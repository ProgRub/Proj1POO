import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo1 extends World
{

    public Máquina máquina;
    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        máquina = new Máquina();
        addObject(máquina,getWidth()/2,getHeight()-150);
        Player1 P1 = new Player1();
        addObject(P1,getWidth()/10,getHeight()-100);
        Player2 P2 = new Player2();
        addObject(P2,(9*getWidth())/10,getHeight()-100);
    }
    
    public void act(){
        atualizaVida(máquina.vida);
    }
    
    private void atualizaVida(int vidaAtualizada){
        showText("" + vidaAtualizada + "%", getWidth()/2,getHeight()-190);
    }
}
