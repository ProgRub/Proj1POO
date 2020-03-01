import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo2 extends World
{
    private int LIMITE=200;
    private int tempo=120;
    private Texto clock;
    private Texto scoreP1;
    private Texto scoreP2;
    private String escreverClock = "2:00";
    private final int TAMANHOTEXTO=45;
    private int contador;
    private boolean control,stop;
    private Nave1 nave1;
    private Nave2 nave2;
    CamadaOzono camadaOzono;

    public Jogo2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,700, 1); 
        prepare();
        control =false;
        stop =false;
        contador =0;
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
        addObject(new Texto("Camada Ozono",TAMANHOTEXTO-10, new Color(255,255,255)),getWidth()/2,575);
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
        libertarGases();        
        disparaMissil();
        vidas();        
        gameOver(camadaOzono.getVida(), nave1.getNumeroVidas(), nave2.getNumeroVidas());
        Options.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        Options.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
        atualizaRelogio();
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
            Greenfoot.setWorld(new Stage2Complete());
        }
    }

    public void libertarGases() 
    {
        if (Greenfoot.getRandomNumber(100)<3)
        {
            addObject(new Gas(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }

    public void vidas() 
    {
        if (Greenfoot.getRandomNumber(500)<1)
        {
            addObject(new Vida_jogo2(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }

    public void disparaMissil(){
        int random = Greenfoot.getRandomNumber(400);
        if (random<2)
        {
            if(random==1 && !getObjects(Nave2.class).isEmpty())
            {
                addObject(new Missil(nave2.getY()+LIMITE,true,nave1,nave2), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
            else if(random==0 & !getObjects(Nave1.class).isEmpty())
            {
                addObject(new Missil(nave1.getY()+LIMITE,false,nave1,nave2), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
        }
    }

    private void gameOver(int vidaCamada, int vidaNave1, int vidaNave2){
        if ( ((vidaNave1 <=0 && vidaNave2 <= 0 ) || vidaCamada <=0 || tempo == 0) && control == false){
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

}  

