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
    private static MenuInicial referencia;
    public Opções(MenuInicial start)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        referencia=start;
    }

    private void prepare()
    {
        int larg = getWidth();
        int comp = getHeight();
        addObject(new Texto("Player 1",50), larg/3, comp/6);
        addObject(new Texto("Player 2",50), (2*larg)/3, comp/6);
        addObject(new Texto("Jump",50), larg/8, 2*comp/6);
        addObject(new Texto("Left",50), larg/8, 3*comp/6);
        addObject(new Texto("Right",50), larg/8, 4*comp/6);
        addObject(new Texto("Shoot",50), larg/8, 5*comp/6);
        addObject(new ControlP1Cima(), larg/3, (2*comp)/6);
        addObject(new ControlP1Esq(), larg/3, (3*comp)/6);
        addObject(new ControlP1Dir(), larg/3, (4*comp)/6);
        addObject(new ControlP1Dispara(), larg/3, (5*comp)/6);
        addObject(new ControlP2Cima(), (2*larg)/3, (2*comp)/6);
        addObject(new ControlP2Esq(), (2*larg)/3, (3*comp)/6);
        addObject(new ControlP2Dir(), (2*larg)/3, (4*comp)/6);
        addObject(new ControlP2Dispara(), (2*larg)/3, (5*comp)/6);
        addObject(new Back(), larg-100, comp-50);
    }
    
    public static MenuInicial getReferencia()
    {
        return referencia;
    }
}
