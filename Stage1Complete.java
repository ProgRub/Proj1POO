import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StageComplete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1Complete extends World
{

    /**
     * Constructor for objects of class StageComplete.
     * 
     */
    public Stage1Complete()
    {    

        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("Stage1Complete.png");
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
        Menu menu = new Menu();
        addObject(menu,500,468);
        NextLevel nextLevel = new NextLevel();
        addObject(nextLevel,700,468);
        RestartLevel restartLevel = new RestartLevel();
        addObject(restartLevel,600,468);
    }
}
