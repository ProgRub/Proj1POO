import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo2 extends World
{

    /**
     * Constructor for objects of class Jogo2.
     * 
     */
    public Jogo2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300,700, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Gas gas = new Gas();
        addObject(gas,93,651);
        Gas gas2 = new Gas();
        addObject(gas2,192,647);
        Gas gas3 = new Gas();
        addObject(gas3,321,635);
        Gas gas4 = new Gas();
        addObject(gas4,439,650);
        Gas gas5 = new Gas();
        addObject(gas5,603,640);
        Gas gas6 = new Gas();
        addObject(gas6,727,656);
        Gas gas7 = new Gas();
        addObject(gas7,866,640);
        gas7.setLocation(1092,636);
        gas6.setLocation(940,641);
        gas5.setLocation(762,647);
        gas4.setLocation(595,645);
        gas3.setLocation(391,644);
        gas2.setLocation(234,652);
        Nave1 nave1 = new Nave1();
        addObject(nave1,172,133);
        Nave2 nave2 = new Nave2();
        addObject(nave2,1054,371);
        nave2.setLocation(1001,379);
        nave1.setLocation(229,132);
        nave1.setLocation(189,131);
        nave2.setLocation(1084,400);
    }
}
