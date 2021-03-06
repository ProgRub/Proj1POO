import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Missil extends Jogos
{
    private int limite;
    private Nave2 nave2;
    private Nave1 nave1;
    private boolean Nave2EAlvo;
    private int contador;
    private GreenfootImage[] animaExplosao;
    private int indice;
    private boolean explosao;

    /**
     * Construtor que define qual o alvo do missil e este é "pintado" de acordo com a cor do alvo e
     * define a altura limite depois da qual o missil já não é teleguiado
     */
    public Missil(int valor,boolean alvoENave2, Nave1 N1, Nave2 N2)
    {
        limite=valor;
        nave2=N2;
        nave1=N1;
        explosao=false;
        if (alvoENave2) //o missil fica com a cor do alvo
        {
            setImage(Player2.getColor()+"/Missil.png");
        }
        else
        {
            setImage(Player1.getColor()+"/Missil.png");
        }
        Nave2EAlvo=alvoENave2;
        animaExplosao = new GreenfootImage[15];
        getImage().scale(getImage().getWidth()/8, getImage().getHeight()/8);
        for (int i=0; i < animaExplosao.length; i++)
        {
            animaExplosao[i] = new GreenfootImage("ExplosionMisseis/"+(i+1)+".png");
        }
        contador=0;
        indice=0;
    }

    public void act() 
    {      
        geral();
    }   

    /**
     * Método responsável por fazer as ações do missil
     */
    private void geral()
    {
        if(!explosao)
        {
            if (Nave2EAlvo)
            {
                teleguiado(nave2);
            }
            else
            {
                teleguiado(nave1);
            }
            atingiuAlvo();
            if(!explosao){
                chegouAoFim();
            }
        }
        else
        {
            animaExplosao();
        } 
    }

    /**
     * Métodos que vão teleguiar o míssil consoante a posição do alvo
     */
    private void teleguiado(Nave2 alvo){
        if(getY()>limite)
        {
            if (!getWorld().getObjects(Nave2.class).isEmpty()) //se a nave for destruida antes deste missil sair do mundo, este if evita que se va buscar a localização
            {
                turnTowards(alvo.getX(), alvo.getY());
            }
        }
        move(2);
    }    

    private void teleguiado(Nave1 alvo){
        if(getY()>limite)
        {
            if (!getWorld().getObjects(Nave1.class).isEmpty()) //se a nave for destruida antes deste missil sair do mundo, este if evita que se va buscar a localização
            {
                turnTowards(alvo.getX(), alvo.getY());
            }
        }
        move(2);
    }

    /**
     * Método que verifica que este chegou a um limite do mundo
     */
    private void chegouAoFim(){
        if(isAtEdge())
        {
            explosao=false;
            getWorld().removeObject(this);
        }
    }

    /**
     * Métodos que registam que o míssil atingiu uma das naves, retirando ao jogador cuja nave foi atingida vida e pontuação
     */
    private void atingiuAlvo()
    {
        if (isTouching(Nave2.class))
        {
            Player2.adicionaNumeroVidas(-1);
            Player2.adicionaScore(-100);
            setLocation(getX(), getY()-getImage().getHeight()); // poe a explosao do missil mais para cima, para parecer que é na nave
            explosao=true;
            getImage().clear();
        }
        else if (isTouching(Nave1.class))
        {
            Player1.adicionaNumeroVidas(-1);
            Player1.adicionaScore(-100);
            setLocation(getX(), getY()-getImage().getHeight());// poe a explosao do missil mais para cima, para parecer que é na nave
            explosao=true;
            getImage().clear();
        }
    }

    /**
     * Método que anima a explosão do míssil quando este atinge uma nave
     */
    private void animaExplosao()
    {
        if (contador%3==0)
        {
            if(indice==0)
            {
                GreenfootSound som = new GreenfootSound("explosion.mp3");
                som.play();
                som.setVolume(15);
            }
            setImage(animaExplosao[indice]);
            indice++;
            if(indice>=animaExplosao.length)
            {
                getWorld().removeObject(this);
            }
        }
        contador++;
    }
}