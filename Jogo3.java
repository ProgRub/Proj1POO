import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogo3 extends World
{
    private int contadorMar;
    private static int pinguinsSalvos;
    private final int ALTURA1=300;
    private final int ALTURA2=400;
    private final int ALTURA3=500;
    private Texto scoreP1, scoreP2,pinguins;
    private final int TAMANHOTEXTO=45;
    private int contador;
    private int altura_anterior;
    private int conta_plataformas;
    private boolean control;
    private static boolean P1Chegou, P2Chegou;
    private final int NUMPLATAFORMASPARAGANHAR=25;
    private Esquimó1 esq1;
    private Esquimó2 esq2;
    private static GreenfootSound somAmbiente;
    public Jogo3()
    {    
        super(1200, 700, 1); 
        contadorMar=0;
        prepare();
        contador = 150;
        altura_anterior=0; //o valor 0 não interfere com a escolha da altura na primeira interação, apenas serve para inicializar a variável
        conta_plataformas=0;
        control = false;
        P1Chegou=false;
        P2Chegou=false;
        pinguinsSalvos = 0;
    }

    private void prepare()
    {

        setPaintOrder(Texto.class, GameOver.class, Restart.class, Player1.class, Player2.class, Pinguim.class, PlataformaGelo.class);
        Mar mar = new Mar();
        addObject(mar,603,getHeight() -30);
        Mar mar2 = new Mar();
        addObject(mar2,1012,getHeight() -30);

        esq1 = new Esquimó1();
        addObject(esq1,390,300);
        esq2 = new Esquimó2();
        addObject(esq2,410,300);

        scoreP1 = new Texto(""+Player1.getScore(),TAMANHOTEXTO, new Color(0,0,0));
        addObject(scoreP1, 285/2, 125);
        scoreP2 = new Texto(""+Player2.getScore(),TAMANHOTEXTO, new Color(0,0,0));
        addObject(scoreP2, getWidth()-285/2, 125);
        addObject(new Texto(Player1.getNome(),TAMANHOTEXTO, new Color(0,0,0)),285/2,80);
        addObject(new Texto(Player2.getNome(),TAMANHOTEXTO, new Color(0,0,0)),getWidth()-285/2,80);

        addObject(new Plataforma_Inicial(),400,ALTURA2);
        
        addObject(new ContarPinguins(), getWidth()/2 - 20, 90);
        pinguins = new Texto(""+pinguinsSalvos,TAMANHOTEXTO, new Color(0,0,0));
        addObject(pinguins,getWidth()/2 +20, 90); 
        
        addObject(new Bandeira_Start(),400,348);
        somAmbiente = new GreenfootSound("snowField.mp3");
        somAmbiente.playLoop();
        somAmbiente.setVolume(30);
    }

    public void act(){
        geral();
        invocarMar();
        
    }
    
    public void geral(){
        if(!control)
        {
            invocarPlataformas();
            vitoria(P1Chegou,P2Chegou);
        }
        gameOver(esq1.getNumeroVidas(), esq2.getNumeroVidas());
        pinguins.updateText(""+pinguinsSalvos,pinguins,TAMANHOTEXTO, pinguins.getCor());
        scoreP1.updateText(""+Player1.getScore(), scoreP1, TAMANHOTEXTO, scoreP1.getCor());
        scoreP2.updateText(""+Player2.getScore(), scoreP2, TAMANHOTEXTO, scoreP2.getCor());
    }
    
    /**
     * Métodos que incrementa o contador de pinguins salvos
     */
    public static void incrementarPinguimSalvo(){
        pinguinsSalvos++;
    }

    /**
     * Métodos que permitem na classe de Esquimó1 e 2 registar que estes chegaram à plataforma final
     */
    public static void setP1Chegou(boolean x)
    {
        P1Chegou=x;
    }

    public static void setP2Chegou(boolean x)
    {
        P2Chegou=x;
    }

    /**
     * Método que permite invocar as plataformas de gelo que os jogadores utilizarão para chegar ao fim
     */
    public void invocarPlataformas() 
    {
        int random =Greenfoot.getRandomNumber(3);
        if (contador%150==0 && conta_plataformas<NUMPLATAFORMASPARAGANHAR+1)
        {
            while(altura_anterior==2 && random ==0)
            {
                random = Greenfoot.getRandomNumber(3);
            }
            switch (random)
            {
                case 0:
                addObject(new PlataformaGelo(-conta_plataformas),getWidth()-1,ALTURA1);
                break;
                case 1:
                addObject(new PlataformaGelo(-conta_plataformas),getWidth()-1,ALTURA2);
                break;
                case 2:
                addObject(new PlataformaGelo(-conta_plataformas),getWidth()-1,ALTURA3);
                break;
            }       
            conta_plataformas++;
            altura_anterior=random;
        }       

        if(contador%150==0 && conta_plataformas==NUMPLATAFORMASPARAGANHAR)
        {
            addObject(new Plataforma_Final(),getWidth()-1,640);   
            addObject(new Bandeira_Finish(),getWidth()-1,530);
        }
        contador++;
    }
    
    public void invocarMar(){
        contadorMar++;
        if(contadorMar == 200){
            addObject(new Mar(),getWidth()-10,getHeight() -30);
            contadorMar=0;
        }
    }

    /**
     * Método que verifica se um dos jogadores caiu e morreu, o que indica que ambos os jogadores, como equipa, perderam o jogo
     */
    private void gameOver(int vidaJogador1, int vidaJogador2){
        if ((vidaJogador1 <=0 || vidaJogador2 <= 0) && !control ){
            addObject(new GameOver(),getWidth()/2,getHeight()/2);
            addObject(new Restart(),getWidth()/2,getHeight()/2 +150);
            somAmbiente.stop();
            Greenfoot.playSound("gameOver.mp3");
            control =true;
        }
    }

    /**
     * Método que verifica se ambos os jogadores chegaram à plataforma final, o que indica que GANHARAM!!
     */
    private void vitoria(boolean P1chegou, boolean P2chegou)
    {
        if(P1chegou && P2chegou)
        {
            somAmbiente.stop();
            Greenfoot.setWorld(new Victory());   
        }
    }
}

