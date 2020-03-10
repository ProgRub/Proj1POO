import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogo1 extends World
{
    private boolean control;
    private int tempo;
    private String escreverClock;
    private Texto scoreP1, scoreP2, clock;
    private Player1 P1;
    private Player2 P2;
    private static GreenfootSound somAmbiente;
    private static GreenfootSound somChuva;
    private int contador, midway, auxNuvem, auxFundo;
    private final int TAMANHOTEXTO=45;
    private GreenfootImage[] fundos;
    private int indice;

    public Jogo1()
    {    
        super(1200, 700, 1); 
        control =false;
        contador=0;
        tempo = 120;
        escreverClock = "2:00";

        auxNuvem = 0;
        setPaintOrder(Texto.class,GameOver.class, Restart.class,VidaMáquina.class,Vida_player1.class,Vida_player2.class,Nuvem.class,Relâmpago.class, Máquina.class, Gas.class,Gota.class );

        auxFundo = -1;
        fundos= new GreenfootImage[9];
        for(int i=0; i <fundos.length;i++)
        {
            fundos[i]=new GreenfootImage("jogo1_backgrounds/jogo1_background_"+(i+1)*5+".jpg");
        }
        indice=0;
        prepare();
    }

    private void prepare()
    {
        somAmbiente = new GreenfootSound("winter.mp3");
        somChuva = new GreenfootSound("rain.mp3");
        somAmbiente.playLoop();
        somAmbiente.setVolume(40);
        Chão chao= new Chão();
        addObject(chao,getWidth()/2,getHeight()-chao.getImage().getHeight()/2);
        Máquina máquina = new Máquina();
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
        if (!control)
        {
            cairGranizo();
            cairNeve();
            invocaTarget();
            cairVida();
            cairChuva();
            aparecerNuvens();
            atualizaRelogio();  
        }
        trocaFundo();
        Options.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        Options.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
    }

    public static GreenfootSound getSomChuva()
    {
        return somChuva;
    }

    /**
     * Método que verifica se um dos jogadores morreu, se isto acontecer, os jogadores perderam o jogo
     */
    private void gameOver(int vidaJogador1, int vidaJogador2){
        if ((vidaJogador1 <=0 || vidaJogador2 <= 0) && !control ){
            addObject(new GameOver(),getWidth()/2,getHeight()/2);
            addObject(new Restart(),getWidth()/2,getHeight()/2 +150);
            somAmbiente.stop();
            somChuva.stop();
            Greenfoot.playSound("gameOver.mp3");
            control =true;
        }
    }

    /**
     * Método que atualiza o tempo que falta para o nível acabar e, quando o tempo acaba,
     * avança para o mundo onde os jogadore podem ver o score total e individual
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
            Options.updateText(escreverClock,clock,TAMANHOTEXTO, Color.RED);
        }
        else
        {
            Options.updateText(escreverClock,clock,TAMANHOTEXTO, Color.WHITE);
        }
        if(tempo==0)
        {
            somAmbiente.stop();
            somChuva.stop();
            Greenfoot.setWorld(new Stage1Complete());
        }
    }

    /**
     * Métodos que criam granizo e neve, respetivamente, enquanto a máquina tem mais de metade da sua vida inicial
     */
    private void cairGranizo() 
    {
        if (Máquina.getVida() > midway )
        {
            if (Greenfoot.getRandomNumber(100)<5)
            {
                addObject(new Granizo(), Greenfoot.getRandomNumber(getWidth()-1),0);
            }
        }

    }

    private void cairNeve() 
    {
        if (Máquina.getVida() > midway ){
            if (Greenfoot.getRandomNumber(100)<10)
            {
                addObject(new Neve(), Greenfoot.getRandomNumber(getWidth()-1),0);
            }
        }
    }

    /**
     * Métodos que criam o alvo onde o relampago cairá e a chuva, respetivamente, após a máquina ter perdido metade da sua vida.
     * Os relâmpagos cairão na posição atual do jogador para incentivar o movimento e dificultar o jogo
     */
    private void invocaTarget() 
    {   
        if(Máquina.getVida() <=midway)
        {
            somAmbiente.stop();
            if(!somChuva.isPlaying())
            {
                somChuva.playLoop();
                somChuva.setVolume(40);
            }
            int prob = Greenfoot.getRandomNumber(2);
            if (Greenfoot.getRandomNumber(250)<4){
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

    private void cairChuva(){
        if (Máquina.getVida() <= midway ){
            if (Greenfoot.getRandomNumber(100)<20)
            {
                addObject(new Gota(), Greenfoot.getRandomNumber(getWidth()-1),0);
            }
        }
    }

    /**
     * Método que cria corações que os jogadores podem apanhar para recuperarem vida que possam ter perdido
     */

    private void cairVida() 
    {
        if (Greenfoot.getRandomNumber(500)<1)
        {
            addObject(new Vida(), Greenfoot.getRandomNumber(getWidth()-1),0);
        }

    }

    /**
     * Métodos que sinalizam que a máquina perdeu metade da sua vida e a "fase" dos relâmpagos começará
     */
    private void aparecerNuvens(){
        if (Máquina.getVida() <= midway && auxNuvem == 0){
            //3 objetos para a nuvem ficar mais escura
            addObject(new Nuvem(1), 0,2);
            addObject(new Nuvem(1), 0,2);
            addObject(new Nuvem(1), 0,2);
            addObject(new Nuvem(-1), getWidth(),10);
            addObject(new Nuvem(-1), getWidth(),10);
            addObject(new Nuvem(-1), getWidth(),10);
            auxNuvem++;
        }
    }

    private void trocaFundo()
    {
        if (Máquina.getVida() <= midway)
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

