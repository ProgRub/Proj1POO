import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogo1 extends World
{
    private Máquina máquina;
    private boolean control;
    private int tempo=10;
    private String escreverClock = "2:00";
    private Texto scoreP1, scoreP2, clock;
    private Player1 P1;
    private Player2 P2;
    private static GreenfootSound somAmbiente;
    private static GreenfootSound somChuva;
    private int contador, midway, auxNuvem, auxNuvem2, auxFundo;
    GreenfootImage fundo1, fundo2, fundo3, fundo4, fundo5, fundo6, fundo7, fundo8,fundo9;
    private final int TAMANHOTEXTO=45;
    private GreenfootImage[] fundos;
    private int indice;

    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        prepare();
        control =false;
        contador=0;

        auxNuvem = 0;
        auxNuvem2 = 0;
        setPaintOrder(Texto.class,GameOver.class, Restart.class,VidaMáquina.class,Nuvem.class,Relâmpago.class, Máquina.class, Gas.class,Gota.class );

        auxFundo = -1;
        fundos= new GreenfootImage[9];
        for(int i=0; i <fundos.length;i++)
        {
            fundos[i]=new GreenfootImage("jogo1_backgrounds/jogo1_background_"+(i+1)*5+".jpg");
        }
        indice=0;
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
        midway=máquina.getVida()/2;
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
        if ((vidaJogador1 <=0 || vidaJogador2 <= 0) && control == false ){
            addObject(new GameOver(),getWidth()/2,getHeight()/2);
            addObject(new Restart(),getWidth()/2,getHeight()/2 +150);
            Greenfoot.playSound("gameOver.mp3");
            control =true;
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
        if (!control)
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
            }
            if (tempo <=10 && contador%61<30)
            {
                Options.updateText(escreverClock,clock,TAMANHOTEXTO, Color.RED);
            }
            else
            {
                Options.updateText(escreverClock,clock,TAMANHOTEXTO, Color.WHITE);
            }
            if(tempo==0)
            {
                Greenfoot.setWorld(new Stage1Complete());
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
                if (prob == 1 && !getObjects(Player1.class).isEmpty())
                {
                    addObject(target, P1.getX(), 620);      
                }
                else if (prob == 0 && !getObjects(Player2.class).isEmpty())
                {
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
            if (auxFundo%12==0 && auxFundo <=96)
            {
                setBackground(fundos[indice]);
                indice++;
            }
            auxFundo++;
        }
    }
}

