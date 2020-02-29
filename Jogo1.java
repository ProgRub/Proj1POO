
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
    private Máquina máquina;
    private boolean control,stop;
    private int timer;

    VidaMáquina vidaMáquina;
    Player1 P1;
    Player2 P2;
    private static GreenfootSound somAmbiente = new GreenfootSound("winter.mp3");
    private static GreenfootSound somChuva = new GreenfootSound("rain.mp3");
    private int wait;
    private int contador;
    private final int midway=máquina.getVida()/2;

    private int auxNuvem;
    private int auxNuvem2;
    GreenfootImage fundo1, fundo2, fundo3, fundo4, fundo5, fundo6, fundo7, fundo8,fundo9;
    private int auxFundo;

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

        auxNuvem = 0;
        auxNuvem2 = 0;
        setPaintOrder(Nuvem.class,Relâmpago.class);
        setPaintOrder(Nuvem.class,Gota.class);
        setPaintOrder(VidaMáquina.class,Nuvem.class);

        auxFundo = -1;
        fundo1 = new GreenfootImage("jogo1_backgrounds/jogo1_background_5.jpg");
        fundo2 = new GreenfootImage("jogo1_backgrounds/jogo1_background_10.jpg");
        fundo3 = new GreenfootImage("jogo1_backgrounds/jogo1_background_15.jpg");
        fundo4 = new GreenfootImage("jogo1_backgrounds/jogo1_background_20.jpg");
        fundo5 = new GreenfootImage("jogo1_backgrounds/jogo1_background_25.jpg");
        fundo6 = new GreenfootImage("jogo1_backgrounds/jogo1_background_30.jpg");
        fundo7 = new GreenfootImage("jogo1_backgrounds/jogo1_background_35.jpg");
        fundo8 = new GreenfootImage("jogo1_backgrounds/jogo1_background_40.jpg");
        fundo9 = new GreenfootImage("jogo1_backgrounds/jogo1_background_45.jpg");

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

        addObject(new Vida_player1(), 285/2, 125);
        addObject(new Vida_player2(), getWidth()-285/2, 125);
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
        aparecerNuvem();
        aparecerNuvem2();
        trocaFundo();
        showText(""+P1.getScore(), 285/2, 200);
        showText(""+P2.getScore(), getWidth()-285/2, 200);
        contador++;
        if(contador%61==0)
        {
            timer++;
        }
        showText(""+timer, getWidth()/2, 300);
    }

    public static GreenfootSound getSomChuva()
    {
        return somChuva;
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

    public void aparecerNuvem(){
        if (máquina.getVida() <= midway && auxNuvem == 0){
            //acrescentei 3 objetos para a nuvem ficar mais escura
            addObject(new Nuvem(), 0,2);
            addObject(new Nuvem(), 0,2);
            addObject(new Nuvem(), 0,2);
            auxNuvem++;
        }
    }

    public void aparecerNuvem2(){
        if (máquina.getVida() <= midway && auxNuvem2 == 0){

            addObject(new Nuvem2(), getWidth(),10);
            addObject(new Nuvem2(), getWidth(),10);
            addObject(new Nuvem2(), getWidth(),10);
            auxNuvem2++;
        }
    }

    public void trocaFundo()
    {
        if (máquina.getVida() <= midway)
        {
            if (auxFundo==0)
            {
                setBackground(fundo1);
            }

            if (auxFundo==12)
            {
                setBackground(fundo2);
            }

            if (auxFundo==24)
            {
                setBackground(fundo3);
            }

            if (auxFundo==36)
            {
                setBackground(fundo4);
            }

            if (auxFundo==48)
            {
                setBackground(fundo5);
            }

            if (auxFundo==60)
            {
                setBackground(fundo6);
            }

            if (auxFundo==72)
            {
                setBackground(fundo7);
            }

            if (auxFundo==84)
            {
                setBackground(fundo8);
            }

            if (auxFundo==96)
            {
                setBackground(fundo9);
            }

            auxFundo++;
        }
    }
}

