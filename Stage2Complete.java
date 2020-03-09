import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Stage2Complete extends World
{
    private int finalScore;
    private Texto score;
    public Stage2Complete()
    {    
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("Stage2Complete.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        IndividualScore.jogo1 = false;
        MenuInicial.getMusica().play(); 
        HowToPlay.mudarJogo(3);
    }
    
    private void prepare()
    {
        Menu menu = new Menu();
        addObject(menu,500,468);
        
        NextLevel nextLevel = new NextLevel();
        addObject(nextLevel,700,468);
        
        PlayersScore players_score = new PlayersScore();
        addObject(players_score,600,468);
        
        finalScore = Player1.getScore() + Player2.getScore();
        score = new Texto("SCORE: "+finalScore,45, new Color(255,255,255));
        addObject(score, getWidth()/2 , getHeight()/2 +15);
    }
}
