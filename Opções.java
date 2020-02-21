import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Opções here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opções extends World
{

    /**
     * Constructor for objects of class Opções.
     * 
     */
    public Opções()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300,700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(1300, 700);
        setBackground(bg);
        prepare();
    }
    
    private void prepare()
    {
        int larg = getWidth();
        int comp = getHeight();
        addObject(new ControlP1Cima(), larg/3, (2*comp)/7);
        addObject(new ControlP1Esq(), larg/3, (3*comp)/7);
        addObject(new ControlP1Dir(), larg/3, (4*comp)/7);
        addObject(new ControlP1Baixo(), larg/3, (5*comp)/7);
        addObject(new ControlP1Dispara(), larg/3, (6*comp)/7);
        addObject(new ControlP2Cima(), (2*larg)/3, (2*comp)/7);
        addObject(new ControlP2Esq(), (2*larg)/3, (3*comp)/7);
        addObject(new ControlP2Dir(), (2*larg)/3, (4*comp)/7);
        addObject(new ControlP2Baixo(), (2*larg)/3, (5*comp)/7);
        addObject(new ControlP2Dispara(), (2*larg)/3, (6*comp)/7);
    }
}
