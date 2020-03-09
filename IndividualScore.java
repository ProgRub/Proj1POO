import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IndividualScore extends World
{
    private Texto scoreP1;
    private Texto scoreP2;
    private GoBack back;
    protected static boolean jogo1;
    public IndividualScore()
    {    
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("individualScore.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
    }

    public void prepare(){
        scoreP1 = new Texto(Player1.getNome()+": "+Player1.getScore(),30, new Color(255,255,255));
        addObject(scoreP1, getWidth()/2 , 260);
        scoreP2 = new Texto(Player2.getNome()+": "+Player2.getScore(),30, new Color(255,255,255));
        addObject(scoreP2, getWidth()/2 , getHeight()/2 +10);

        back = new GoBack();
        addObject(back,getWidth()/2,468);
    }
}
