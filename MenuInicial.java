import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuInicial extends World
{

    private static GreenfootSound musica;
    private boolean reset;
    public MenuInicial(boolean resetControlos)
    {    
        super(1200,700, 1); 
        reset=resetControlos;
        GreenfootImage bg = new GreenfootImage("Earth.png");
        musica = new GreenfootSound("music.mp3");
        musica.play();
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        Greenfoot.setSpeed(50);
    }
    public MenuInicial()
    {    
        super(1200,700, 1); 
        reset=true;
        GreenfootImage bg = new GreenfootImage("Earth.png");
        musica = new GreenfootSound("music.mp3");
        musica.play();
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        Greenfoot.setSpeed(50);
    }

    private void prepare()
    {
        addObject(new Play(),getWidth()/2,349);
        addObject(new Options(),getWidth()/2,420);
        addObject(new Exit(),getWidth()/2,462);
        resetStaticVariables();
    }

    private void resetStaticVariables(){
        if(reset)
        {
            Player1.setControls(0, "w");
            Player1.setControls(1, "a");
            Player1.setControls(2, "d");
            Player1.setControls(3, "f");
            Player2.setControls(0, "up");
            Player2.setControls(1, "left");
            Player2.setControls(2, "right");
            Player2.setControls(3, "0");
        }
        Player1.resetScore();
        Player2.resetScore();
        Player1.resetNumVidas();
        Player2.resetNumVidas();
    }

    public static GreenfootSound getMusica(){
        return musica;
    }
}
