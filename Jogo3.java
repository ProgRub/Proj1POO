import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo3 extends World
{

    /**
     * Constructor for objects of class Jogo3.
     * 
     */

    private int contador;
    private final int ALTURA1=200;
    private final int ALTURA2=350;
    private final int ALTURA3=500;
    private int tempo=120;
    private Texto clock;
    private String escreverClock = "2:00";
    private Texto scoreP1;
    private Texto scoreP2;
    private final int TAMANHOTEXTO=45;

    public Jogo3()
    {    
        super(1200, 700, 1); 
        contador=0;
        prepare();   
    }
    
    private void prepare()
    {
        Mar mar = new Mar();
        addObject(mar,603,getHeight() -30);
        Mar mar2 = new Mar();
        addObject(mar2,1012,getHeight() -30);
        addObject(new Player1(),200,200);
        addObject(new Player2(),400,400);

        addObject(new Vida_player1(), 285/2, 125);
        addObject(new Vida_player2(), getWidth()-285/2, 125);
        clock = new Texto(escreverClock,TAMANHOTEXTO, new Color(0,0,0));
        addObject(clock, getWidth()/2,125);
        scoreP1 = new Texto(""+Player1.getScore(),TAMANHOTEXTO, new Color(0,0,0));
        addObject(scoreP1, 285/2,175);
        scoreP2 = new Texto(""+Player2.getScore(),TAMANHOTEXTO, new Color(0,0,0));
        addObject(scoreP2, getWidth()-285/2,175);
        addObject(new Texto(Player1.getNome(),TAMANHOTEXTO, new Color(0,0,0)),285/2,80);
        addObject(new Texto(Player2.getNome(),TAMANHOTEXTO, new Color(0,0,0)),getWidth()-285/2,80);
    }

    public void act(){
        invocarPlataformas();
        invocarMar();
    }

    public void invocarPlataformas() 
    {
        int random =Greenfoot.getRandomNumber(500);
        if (random<3)
        {
            if (random==0)
            {
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA1);
            }
            else if (random==1)
            {
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA2);
            }
            else
            {
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA3);
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
        }        
        Options.updateText(escreverClock,clock,TAMANHOTEXTO, clock.getCor());
    }

    public void invocarMar(){
        contador++;
        if(contador == 200){
            addObject(new Mar(),getWidth()-10,getHeight() -30);
            contador=0;
        }
    }

}

