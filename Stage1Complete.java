import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Stage1Complete extends World
{
    private int finalScore;
    private Texto score;
    public Stage1Complete()
    {    
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("Stage1Complete.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        IndividualScore.jogo1 = true;
        HowToPlay.mudarJogo(2);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        finalScore = Player1.getScore() + Player2.getScore();
        score = new Texto("SCORE: "+finalScore,45, new Color(255,255,255));
        addObject(score, getWidth()/2 , getHeight()/2 +15);
        
        Menu menu = new Menu();
        addObject(menu,500,468);
        
        NextLevel nextLevel = new NextLevel();
        addObject(nextLevel,700,468);
        
        PlayersScore players_score = new PlayersScore();
        addObject(players_score,600,468);
    }
}
