
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo1 extends World
{
    private Máquina máquina;
    private boolean control,stop;
    private int tempo=120;
    private Texto clock;
    private String escreverClock = "2:00";
    private Texto scoreP1;
    private Texto scoreP2;
    private Player1 P1;
    private Player2 P2;
    private static GreenfootSound somAmbiente;
    private static GreenfootSound somChuva;
    private int contador;
    private final int midway=máquina.getVida()/2;

    private int auxNuvem;
    private int auxNuvem2;
    GreenfootImage fundo1, fundo2, fundo3, fundo4, fundo5, fundo6, fundo7, fundo8,fundo9;
    private int auxFundo;
    private final int TAMANHOTEXTO=45;

    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        prepare();
        control =false;
        stop =false;
        contador=0;

        auxNuvem = 0;
        auxNuvem2 = 0;
        setPaintOrder(Texto.class,GameOver.class, Restart.class,VidaMáquina.class,Nuvem.class,Relâmpago.class, Gas.class,Gota.class );

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

    private void prepare()
    {
        somAmbiente = new GreenfootSound("winter.mp3");
        somChuva = new GreenfootSound("rain.mp3");
        somAmbiente.setVolume(60);
        somAmbiente.play();
        somChuva.setVolume(60);
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
        clock = new Texto(escreverClock,TAMANHOTEXTO, new Color(255,255,255));
        addObject(clock, getWidth()/2,125);
        scoreP1 = new Texto(""+Player1.getScore(),TAMANHOTEXTO, new Color(255,255,255));
        addObject(scoreP1, 285/2,175);
        scoreP2 = new Texto(""+Player2.getScore(),TAMANHOTEXTO, new Color(255,255,255));
        addObject(scoreP2, getWidth()-285/2,175);
        addObject(new Texto(Player1.getNome(),TAMANHOTEXTO-10, new Color(255,255,255)),285/2,80);
        addObject(new Texto(Player2.getNome(),TAMANHOTEXTO-10, new Color(255,255,255)),getWidth()-285/2,80);
    }

    public void act(){
        gameOver(P1.getNumeroVidas(),P2.getNumeroVidas()); 
        cairGranizo();
        cairNeve();
        invocaTarget();
        cairVida();
        cairChuva();
        aparecerNuvens();
        trocaFundo();
        Options.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        Options.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
        atualizaRelogio();
    }

    public static GreenfootSound getSomChuva()
    {
        return somChuva;
    }

    private void gameOver(int vidaJogador1, int vidaJogador2){
        if ((vidaJogador1 <=0 && vidaJogador2 <= 0) && control == false ){
            addObject(new GameOver(),getWidth()/2,getHeight()/2);
            addObject(new Restart(),getWidth()/2,getHeight()/2 +150);
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

    private void atualizaRelogio()
    {
        contador++;        
        if(contador%61==0)
        {
            tempo--;
            if(tempo%60<10)
            {
                escreverClock = "" + tempo/60 + ":0" + tempo%60;
            }
            else
            {
                escreverClock = "" + tempo/60 + ":" + tempo%60;
            }        
            Options.updateText(escreverClock,clock,TAMANHOTEXTO, clock.getCor());
        }
        if(tempo==0)
        {
            Greenfoot.setWorld(new Stage1Complete());
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

    public void aparecerNuvens(){
        if (máquina.getVida() <= midway && auxNuvem == 0){
            //acrescentei 3 objetos para a nuvem ficar mais escura
            addObject(new Nuvem(1), 0,2);
            addObject(new Nuvem(1), 0,2);
            addObject(new Nuvem(1), 0,2);
            addObject(new Nuvem(-1), getWidth(),10);
            addObject(new Nuvem(-1), getWidth(),10);
            addObject(new Nuvem(-1), getWidth(),10);
            auxNuvem++;
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

