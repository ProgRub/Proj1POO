import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Victory extends World
{
    private int finalScore;
    private Texto score;
    
    public Victory()
    {   
        super(1200, 700, 1); 
        Greenfoot.playSound("victory.mp3");
        prepare();
    }
    
    public void prepare(){
        finalScore = Player1.getScore() + Player2.getScore();
        score = new Texto("FINAL SCORE: "+finalScore,40, new Color(255, 255, 255));
        addObject(score, getWidth()/2 , getHeight()/2 +100);
    }
}
