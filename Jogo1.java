
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo1 extends World
{
    GameOver gameOver;
    Restart restart;
    public Máquina máquina;
    public boolean control,stop;
    
    VidaMáquina vidaMáquina;
    Player1 P1;
    Player2 P2;
    GreenfootSound somAmbiente = new GreenfootSound("winter.mp3");
    GreenfootSound somChuva = new GreenfootSound("rain.mp3");
    private int wait;
    private int contador;
    private final int midway=máquina.getVida()/2;
    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        prepare();
        gameOver = new GameOver();
        restart = new Restart();
        control =false;
        stop =false;
        contador=0;
        setPaintOrder(GameOver.class, Restart.class, VidaMáquina.class);
    }

    public  VidaMáquina getVidaMáquina(){
        return vidaMáquina;
    }
    
    private void prepare()
    {
        Chão chao= new Chão();
        addObject(chao,getWidth()/2,getHeight()-chao.getImage().getHeight()/2);
        máquina = new Máquina();
        addObject(máquina,getWidth()/2,getHeight()-chao.getImage().getHeight()-máquina.getImage().getHeight()/2);
        P1 = new Player1();
        addObject(P1,getWidth()/10,getHeight()-chao.getImage().getHeight()-P1.getImage().getHeight()/2+2);
        P2 = new Player2();
        addObject(P2,9*getWidth()/10,getHeight()-chao.getImage().getHeight()-P2.getImage().getHeight()/2+2);

        addObject(new VidaMáquina(),getWidth()/2,40);
        
        addObject(new Vida_player1(P1), 350, 100);
        
        addObject(new Vida_player2(P2), 1050, 100);
        somAmbiente.setVolume(60);
        somAmbiente.play();
        
        somChuva.setVolume(60);
    }

    public void act(){
        gameOver(P1.getNumeroVidas(),P2.getNumeroVidas()); 
        cairGranizo();
        cairNeve();
        invocaTarget();
        cairVida();
        cairChuva();
    }

    
    private void gameOver(int vidaJogador1, int vidaJogador2){
        if (vidaJogador1 <=0 && vidaJogador2 <= 0 && control == false ){
            addObject(gameOver,getWidth()/2,getHeight()/2);
            addObject(restart,getWidth()/2,getHeight()/2 +150);
            stop =true;
            if (stop == true){
                Greenfoot.playSound("gameOver.mp3");
                control =true;
                stop =false;
            }
        }
    }
    
    
    public void cairGranizo() 
    {
        if (máquina.getVida() >midway )
        {
        if (Greenfoot.getRandomNumber(100)<3)
        {
            addObject(new Granizo(), Greenfoot.getRandomNumber(getWidth()-1),0);
        }
    }
        
    }
    
    public void invocaTarget() 
    {   
        if(máquina.getVida() <=midway)
        {
        somAmbiente.stop();
        somChuva.play();
        int prob = Greenfoot.getRandomNumber(2);
        if (Greenfoot.getRandomNumber(500)<3){
            Target target = new Target();
            if (prob == 1){
                addObject(target, P1.getX(), 620);      
            }
            else{
                addObject(target, P2.getX(), 620);            
            }                     
        } 
    }
    }
    
    public void cairNeve() 
    {
        if (máquina.getVida() > midway ){
            if (Greenfoot.getRandomNumber(100)<10)
            {
                addObject(new Neve(), Greenfoot.getRandomNumber(getWidth()-1),0);
            }
        }
    }
    
    public void cairChuva(){
        if (máquina.getVida() <= midway ){
            if (Greenfoot.getRandomNumber(100)<20)
            {
                addObject(new Gota(), Greenfoot.getRandomNumber(getWidth()-1),0);
            }
        }
    }
    
    public void cairVida() 
    {
        if (Greenfoot.getRandomNumber(500)<1)
        {
            addObject(new Vida(), Greenfoot.getRandomNumber(getWidth()-1),0);
        }
        
    }
    
}
