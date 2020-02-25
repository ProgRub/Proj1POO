import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuInicial extends World
{

    GreenfootSound musica;
    public MenuInicial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        musica = new GreenfootSound("music.mp3");
        musica.play();
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Play(),getWidth()/2,349);
        addObject(new Options(),getWidth()/2,420);
        addObject(new Exit(),getWidth()/2,462);
        resetStaticVariables();
    }
    
    private void resetStaticVariables(){
        Player1.setControls(0, "w");
        Player1.setControls(1, "a");
        Player1.setControls(2, "d");
        Player1.setControls(3, "s");
        Player1.setControls(4, "f");
        Player2.setControls(0, "up");
        Player2.setControls(1, "left");
        Player2.setControls(2, "right");
        Player2.setControls(3, "down");
        Player2.setControls(4, "0");
    }
}
