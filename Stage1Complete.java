import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Stage1Complete extends World
{
    private int finalSore;
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
        PlayersScore players_score = new PlayersScore();
        addObject(players_score,600,468);
    }
}
