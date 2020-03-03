import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo3 extends World
{
    private int contadorMar, contador;
    private final int ALTURA1=300;
    private final int ALTURA2=400;
    private final int ALTURA3=500;
    private int tempo=120;
    //private Texto clock;
    //private String escreverClock = "2:00";
    private Texto scoreP1;
    private Texto scoreP2;
    private final int TAMANHOTEXTO=45;
    private int CONTADOR;
    private int altura_anterior;
    private int conta_plataformas;
    
    
    public Jogo3()
    {    
        super(1200, 700, 1); 
        contadorMar=0;
        prepare();
        CONTADOR = 150;
        altura_anterior=0; //o valor 0 não interfere com a escolha da altura na primeira interação, apenas serve para inicializar a variável
        conta_plataformas=0;
        
    }
    
    private void prepare()
    {
        
        setPaintOrder(Texto.class, GameOver.class, Restart.class, Player1.class, Player2.class, Pinguim.class, PlataformaGelo.class);
        Mar mar = new Mar();
        addObject(mar,603,getHeight() -30);
        Mar mar2 = new Mar();
        addObject(mar2,1012,getHeight() -30);

        

        addObject(new Esquimó1(),390,300);
        addObject(new Esquimó2(),410,300);


        addObject(new Vida_player1(), 285/2, 125);
        addObject(new Vida_player2(), getWidth()-285/2, 125);
        //clock = new Texto(escreverClock,TAMANHOTEXTO, new Color(0,0,0));
        //addObject(clock, getWidth()/2,125);
        scoreP1 = new Texto(""+Player1.getScore(),TAMANHOTEXTO, new Color(0,0,0));
        addObject(scoreP1, 285/2,175);
        scoreP2 = new Texto(""+Player2.getScore(),TAMANHOTEXTO, new Color(0,0,0));
        addObject(scoreP2, getWidth()-285/2,175);
        addObject(new Texto(Player1.getNome(),TAMANHOTEXTO, new Color(0,0,0)),285/2,80);
        addObject(new Texto(Player2.getNome(),TAMANHOTEXTO, new Color(0,0,0)),getWidth()-285/2,80);
        

        addObject(new Plataforma_Inicial(),400,ALTURA2);

        addObject(new Bandeira_Start(),400,348);

        
    }

    public void act(){
        invocarPlataformas();
        invocarMar();
<<<<<<< HEAD
        //atualizaRelogio();
=======
        atualizaRelogio();
        Options.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        Options.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
>>>>>>> 6455072b89ae272b7936c9f43a673d8a908a41a6
    }

    public void invocarPlataformas() 
    {
        int random =Greenfoot.getRandomNumber(3);
        int random2 =Greenfoot.getRandomNumber(2);
        if (CONTADOR%150==0 && conta_plataformas<34)
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
       
            conta_plataformas++;
        }
        
        
        
        if(CONTADOR%150==0 && conta_plataformas==30)
        {
                addObject(new Plataforma_Final(),getWidth()-1,640);
                addObject(new Bandeira_Finish(),getWidth()-1,530);
                
        }
       
        CONTADOR++;
        
    }

    /*private void atualizaRelogio()
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
    }*/
    

    public void invocarMar(){
        contadorMar++;
        if(contadorMar == 200){
            addObject(new Mar(),getWidth()-10,getHeight() -30);
            contadorMar=0;
        }
    }

}

