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
    private Texto scoreP1;
    private Texto scoreP2;
    private final int TAMANHOTEXTO=45;
    private int CONTADOR;
    private int altura_anterior;
    private int conta_plataformas;
    private boolean control, stop;
    private static boolean P1Chegou, P2Chegou;
    private final int NUMPLATAFORMASPARAGANHAR=20;
    public Jogo3()
    {    
        super(1200, 700, 1); 
        contadorMar=0;
        prepare();
        CONTADOR = 150;
        altura_anterior=0; //o valor 0 não interfere com a escolha da altura na primeira interação, apenas serve para inicializar a variável
        conta_plataformas=0;
        control = false;
        stop = false;
        P1Chegou=false;
        P2Chegou=false;
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
        gameOver(Player1.getNumeroVidas(), Player2.getNumeroVidas());
        Options.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        Options.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
        vitoria(P1Chegou,P2Chegou);
    }

    public static void setP1Chegou(boolean x)
    {
        P1Chegou=x;
    }

    public static void setP2Chegou(boolean x)
    {
        P2Chegou=x;
    }

    public void invocarPlataformas() 
    {
        int random =Greenfoot.getRandomNumber(3);
        int random2 =Greenfoot.getRandomNumber(2);
        if (CONTADOR%150==0 && conta_plataformas<NUMPLATAFORMASPARAGANHAR+1)
        {
            while(altura_anterior==2 && random ==0)
            {
                random = Greenfoot.getRandomNumber(3);
            }
            switch (random)
            {
                case 0:
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA1);
                break;
                case 1:
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA2);
                break;
                case 2:
                addObject(new PlataformaGelo(),getWidth()-1,ALTURA3);
                break;
            }       
            conta_plataformas++;
            altura_anterior=random;
        }       

        if(CONTADOR%150==0 && conta_plataformas==NUMPLATAFORMASPARAGANHAR)
        {
            addObject(new Plataforma_Final(),getWidth()-1,640);   
            addObject(new Bandeira_Finish(),getWidth()-1,530);
        }

        CONTADOR++;

    }

    public void invocarMar(){
        contadorMar++;
        if(contadorMar == 200){
            addObject(new Mar(),getWidth()-10,getHeight() -30);
            contadorMar=0;
        }
    }

    private void gameOver(int vidaJogador1, int vidaJogador2){
        if ((vidaJogador1 <=0 || vidaJogador2 <= 0) && control == false ){
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

    private void vitoria(boolean P1chegou, boolean P2chegou)
    {
        if(P1chegou && P2chegou)
        {
            Greenfoot.setWorld(new Victory());   
        }
    }
}

