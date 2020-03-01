import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo3 extends World
{
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
    private int CONTADOR;
    private int altura_anterior;
    
    public Jogo3()
    {    
        super(1200, 700, 1); 
        contador=0;
        prepare();
        CONTADOR = 150;
        altura_anterior=0; //o valor 0 não interfere com a escolha da altura na primeira interação, apenas serve para inicializar a variável
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
        
        addObject(new Plataforma_Inicial(),400,304);
    }

    public void act(){
        invocarPlataformas();
        invocarMar();
    }

    public void invocarPlataformas() 
    {
        int random =Greenfoot.getRandomNumber(3);
        int random2 =Greenfoot.getRandomNumber(2);
        if (CONTADOR%150==0)
        {
            if (random==0 && altura_anterior !=2)
            {
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA1);
                altura_anterior = random;
            }
            
            if (random==0 && altura_anterior ==2)
            {
                if(random2==0)
                {
                    addObject(new PlataformaGelo(),getWidth()-1,ALTURA2);
                }
                
                else
                {
                    addObject(new PlataformaGelo(),getWidth()-1,ALTURA3);
                }
                altura_anterior = random2+1;
            }
            
            if (random==1)
            {
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA2);
                altura_anterior = random;
            }
            
            if (random==2)
            {
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA3);
                altura_anterior = random;
            }
            
        }
        CONTADOR++;
        
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

