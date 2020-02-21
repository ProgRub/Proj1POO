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
        Gas gas = new Gas();
        addObject(gas,568,400);
        Máquina máquina = new Máquina();
        addObject(máquina,706,454);
        gas.setLocation(632,241);
        máquina.setLocation(611,497);
        gas.setLocation(600,430);
        Gas gas2 = new Gas();
        addObject(gas2,595,387);
        Gas gas3 = new Gas();
        addObject(gas3,564,331);
        Gas gas4 = new Gas();
        addObject(gas4,633,301);
        gas.setLocation(705,371);
        gas.setLocation(633,181);
        máquina.setLocation(591,496);
        gas2.setLocation(592,374);
        gas4.setLocation(636,325);
        gas.setLocation(589,259);
        Relâmpago relâmpago = new Relâmpago();
        addObject(relâmpago,959,180);
        Relâmpago relâmpago2 = new Relâmpago();
        addObject(relâmpago2,251,204);
        removeObject(relâmpago2);
        relâmpago.setLocation(841,331);
        relâmpago.setLocation(875,300);
        relâmpago.setLocation(882,220);
        removeObject(relâmpago);
    }
}
