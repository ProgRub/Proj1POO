import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Opções extends World
{
    private final int TAMANHOTEXTO=50;
    public Opções()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
    }

    private void prepare()
    {
        int larg = getWidth();
        int comp = getHeight();
        addObject(new Texto("Player 1",TAMANHOTEXTO, new Color(255,255,255)), larg/3, comp/6);
        addObject(new Texto("Player 2",TAMANHOTEXTO, new Color(255,255,255)), (2*larg)/3, comp/6);
        addObject(new Texto("Jump",TAMANHOTEXTO, new Color(255,255,255)), larg/8, 2*comp/6);
        addObject(new Texto("Left",TAMANHOTEXTO, new Color(255,255,255)), larg/8, 3*comp/6);
        addObject(new Texto("Right",TAMANHOTEXTO, new Color(255,255,255)), larg/8, 4*comp/6);
        addObject(new Texto("Shoot",TAMANHOTEXTO, new Color(255,255,255)), larg/8, 5*comp/6);

        addObject(new Controlos(1,0), larg/3, (2*comp)/6);
        addObject(new Controlos(1,1), larg/3, (3*comp)/6);
        addObject(new Controlos(1,2), larg/3, (4*comp)/6);
        addObject(new Controlos(1,3), larg/3, (5*comp)/6);
        addObject(new Controlos(2,0), (2*larg)/3, (2*comp)/6);
        addObject(new Controlos(2,1), (2*larg)/3, (3*comp)/6);
        addObject(new Controlos(2,2), (2*larg)/3, (4*comp)/6);
        addObject(new Controlos(2,3), (2*larg)/3, (5*comp)/6);
        addObject(new Back(), larg-100, comp-50);
    }
}
