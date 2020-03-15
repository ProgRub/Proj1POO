import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogo2 extends World
{
    private final int LIMITE=200;
    private int tempo;
    private Texto clock;
    private Texto scoreP1,scoreP2;
    private String escreverClock;
    private final int TAMANHOTEXTO=45;
    private int contador;
    private boolean control;
    private Nave1 nave1;
    private Nave2 nave2;
    private CamadaOzono camadaOzono;
    private int quantoGas;
    private GreenfootSound ambiente;

    public Jogo2()
    {    
        super(1200, 700, 1); 
        tempo=120;
        escreverClock = "2:00";
        control =false;
        contador = 0;
        ambiente = new GreenfootSound("music2.mp3");
        ambiente.play();
        quantoGas = Máquina.getVida()/5; //variável que determinará a quantidade de gás criado dependendo da quantidade de dano efetuado à máquina no nível anterior
        prepare();
    }

    private void prepare()
    {
        nave1 = new Nave1();
        addObject(nave1,getWidth()/2,100);
        nave2 = new Nave2();
        addObject(nave2,getWidth()/2,200);

        addObject(new Vida_player1(),285/2,600);
        addObject(new Vida_player2(),getWidth()-285/2,600);

        camadaOzono= new CamadaOzono();
        addObject(camadaOzono,getWidth()/2, 20);
        addObject(new VidaCamadaOzono(), getWidth()/2, 600);

        addObject(new Texto("Ozone Layer",TAMANHOTEXTO-10, new Color(255,255,255)),getWidth()/2,575);
        setPaintOrder(Texto.class, GameOver.class, Restart.class, CamadaOzono.class, Player1.class, Player2.class, Gas.class);
        clock = new Texto(escreverClock,TAMANHOTEXTO, new Color(255,255,255));
        addObject(clock, getWidth()/2,650);
        scoreP1 = new Texto(""+Player1.getScore(),TAMANHOTEXTO, new Color(255,255,255));
        addObject(scoreP1, 285/2,645);
        scoreP2 = new Texto(""+Player2.getScore(),TAMANHOTEXTO, new Color(255,255,255));
        addObject(scoreP2, getWidth()-285/2,645);
        addObject(new Texto(Player1.getNome(),TAMANHOTEXTO-10, new Color(255,255,255)),285/2,555);
        addObject(new Texto(Player2.getNome(),TAMANHOTEXTO-10, new Color(255,255,255)),getWidth()-285/2,555);

    }

    public void act()
    {
        if(!control)
        {
            libertarGases();        
            disparaMissil();
            vidas();
            atualizaRelogio();
        }
        gameOver(camadaOzono.getVida(), nave1.getNumeroVidas(), nave2.getNumeroVidas());
        scoreP1.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        scoreP2.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
    }

    /**
     * Ver Jogo1 para explicação deste método
     */
    
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
        }
        if (tempo <=10 && contador%61<30)
        {
            clock.updateText(escreverClock,clock,TAMANHOTEXTO, Color.RED);
        }
        else
        {
            clock.updateText(escreverClock,clock,TAMANHOTEXTO, Color.WHITE);
        }
        if(tempo==0)
        {
            ambiente.stop();
            Greenfoot.setWorld(new Stage2Complete());
        }
    }

    /**
     * Método que cria os gases que fazem dano à camada de ozono e que os jogadores devem "apanhar"
     */
    private void libertarGases() 
    {
        if (Greenfoot.getRandomNumber(100-quantoGas)<3)
        {
            addObject(new Gas(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }
    
    /**
     * Método que cria os corações que os jogadores podem apanhar para restaurarem vida que perderam, como no jogo 1
     */
    private void vidas() 
    {
        if (Greenfoot.getRandomNumber(500)<1)
        {
            addObject(new Vida_jogo2(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }

    /**
     * Método que cria os misseís teleguiados aos jogadores
     */
    private void disparaMissil(){
        int random = Greenfoot.getRandomNumber(300);
        if (random<2)
        {
            if(random==1)
            {
                addObject(new Missil(nave2.getY()+LIMITE,true,nave1,nave2), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
            else if(random==0)
            {
                addObject(new Missil(nave1.getY()+LIMITE,false,nave1,nave2), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
        }
    }
 
    /**
     * Método que verifica se um dos jogadores morreu ou, neste caso, a camada de ozono foi destruída completamente, se qualquer destes eventos acontecerem, os jogadores perderam o jogo
     */
    private void gameOver(int vidaCamada, int vidaNave1, int vidaNave2){
        if ( ((vidaNave1 <=0 || vidaNave2 <= 0 ) || vidaCamada <=0) && !control){
            ambiente.stop();
            addObject(new GameOver(),getWidth()/2,getHeight()/2);
            addObject(new Restart(),getWidth()/2,getHeight()/2 +150);
            Greenfoot.playSound("gameOver.mp3");
            control =true;
        }

    }

}  

