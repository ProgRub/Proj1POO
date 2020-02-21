import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo1 extends World
{

    /**
     * Constructor for objects of class Jogo1.
     * 
     */
    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 700, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Máquina máquina = new Máquina();
        addObject(máquina,591,496);
<<<<<<< HEAD
        
=======
        Player1 P1 = new Player1();
        addObject(P1,200,600);
        Player2 P2 = new Player2();
        addObject(P2,1100,600);
>>>>>>> 8f18417109c835d321480f492c0e764f3cd48ad5
    }
}
