import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage2Complete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2Complete extends World
{

    /**
     * Constructor for objects of class Stage2Complete.
     * 
     */
    public Stage2Complete()
    {    
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("Stage2Complete.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
    }
    
    private void prepare()
    {
        Menu menu = new Menu();
        addObject(menu,500,468);
        NextLevel nextLevel = new NextLevel();
        addObject(nextLevel,700,468);
        RestartLevel restartLevel = new RestartLevel();
        addObject(restartLevel,600,468);
    }
}
