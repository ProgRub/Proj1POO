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
        Nave1 nave1 = new Nave1();
        addObject(nave1,620,66);
        Nave2 nave2 = new Nave2();
        addObject(nave2,623,198);
    }
    
    
    public void act()
    {
        libertarGases();
    }
    
    public void libertarGases() 
    {
         
        if (Greenfoot.getRandomNumber(100)<3)
        {
            int x =Greenfoot.getRandomNumber(1301);
            int y = getHeight();
            addObject(new Gas(), x,y);
        }
    }

    
    

    
    
    
    
}

    