import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuInicial extends World
{

    /**
     * Constructor for objects of class MenuInicial.
     * 
     */
    public MenuInicial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300,700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(1300, 700);
        setBackground(bg);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,656,349);
        Exit exit = new Exit();
        addObject(exit,1268,666);
        Options options = new Options();
        addObject(options,1216,667);
        Relâmpago relâmpago = new Relâmpago();
        addObject(relâmpago,1054,299);
        removeObject(relâmpago);
    }
}
