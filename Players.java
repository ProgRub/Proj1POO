import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players extends Actor
{
    private boolean tocandoRelampago;
    private int contador;
    protected int indice;
    private int auxDeath;
    private int indiceDeath;
    private boolean control;
    protected static final int GRAVIDADE =15;
    protected int tempoJump;
    protected int tempoQueda;
    protected boolean podeSaltar;
    protected boolean saltou;
    protected boolean andandoParaEsquerda;
    protected int controlBala;
    private GreenfootSound atingido, apanhouVida;

    public Players()
    {
        tocandoRelampago = false;
        contador=0;
        indice=0;
        auxDeath=0;
        indiceDeath=0;
        control=true;
        tempoJump=GRAVIDADE;
        tempoQueda=GRAVIDADE;
        podeSaltar=false;
        saltou=false;
        andandoParaEsquerda=false;
        controlBala=0;
        atingido = new GreenfootSound("PlayerHit.mp3");
        apanhouVida = new GreenfootSound("getsHealth.mp3");
    }

    public void act() 
    {
    } 
    /**
     * Métodos que registam a perda, ou ganho, de vidas consoante o objeto que os jogadores tocam no primeiro jogo
     */
    protected void perdeVidas(Player1 P1)
    {
        if(P1.getNumeroVidas()>0){
            if(isTouching(Granizo.class))
            {
                playAtingido();
                P1.adicionaNumeroVidas(-1); 
                P1.adicionaScore(-50);
                removeTouching(Granizo.class);
            }

            if(isTouching(Relâmpago.class))
            {
                if (!tocandoRelampago)
                {
                    P1.adicionaNumeroVidas(-2);
                    P1.adicionaScore(-100);
                    tocandoRelampago = true;
                }
            }
            else
            {
                tocandoRelampago = false;
            }

            if(isTouching(Vida.class) )
            {
                playVida();
                P1.adicionaNumeroVidas(2);
                P1.adicionaScore(25);
                removeTouching(Vida.class);

            }
        }

    }

    protected void perdeVidas(Player2 P2)
    {
        if(P2.getNumeroVidas()>0){
            if(isTouching(Granizo.class))
            {
                playAtingido();
                P2.adicionaNumeroVidas(-1); 
                P2.adicionaScore(-50);
                removeTouching(Granizo.class);
            }
            if(isTouching(Relâmpago.class))
            {
                if (!tocandoRelampago)
                {
                    P2.adicionaNumeroVidas(-2);
                    P2.adicionaScore(-100);
                    tocandoRelampago = true;
                }
            }
            else
            {
                tocandoRelampago = false;
            }
            if(isTouching(Vida.class))
            {
                playVida();
                P2.adicionaNumeroVidas(2); 
                P2.adicionaScore(25);
                removeTouching(Vida.class);
            }
        }
    }

    /**
     * Métodos que registam que as naves apanharam vida no segundo jogo
     */
    protected void perdeVidas(Nave1 N1)
    {
        if(N1.getNumeroVidas()>0)
        {
            if(isTouching(Vida_jogo2.class))
            {
                playVida();
                N1.adicionaNumeroVidas(2);
                N1.adicionaScore(25);
                removeTouching(Vida_jogo2.class);
            }
        }

    }

    protected void perdeVidas(Nave2 N2)
    {
        if(N2.getNumeroVidas()>0)
        {
            if(isTouching(Vida_jogo2.class))
            {
                playVida();
                N2.adicionaNumeroVidas(2); 
                N2.adicionaScore(25);
                removeTouching(Vida_jogo2.class);
            }

        }

    }

    /**
     * Método que trata da animação do movimento do jogador
     */
    protected void animarMove(GreenfootImage[] animacao){
        contador++;
        if (contador==4){
            if(indice<animacao.length-1)
            {
                indice++;
            }
            else
            {
                indice=1;
            }
            setImage(animacao[indice]);
            contador=0;
        }
    }

    /**
     * Método que trata da animação da morte do jogador
     */
    protected void animarMorte(GreenfootImage[] animacaoDeath, boolean andandoParaEsquerda)
    {
        if(andandoParaEsquerda && control)
        {
            for (int i=0; i < animacaoDeath.length;i++)
            {
                animacaoDeath[i].mirrorHorizontally();
            }
            control=false;
        }
        if(auxDeath%10==0)
        {
            Player1.setP2Morreu(true);
            Player2.setP1Morreu(true);
            setImage(animacaoDeath[indiceDeath]);
            indiceDeath++;
            if (indiceDeath>=animacaoDeath.length)
            {
                getWorld().removeObject(this);
            }
        }
        auxDeath++;
    }    

    /**
     * Método que anima a explosão quando a nave é destruída
     */
    protected void naveDestruida(GreenfootImage[] explosao){
        if (contador%3==0){
            Player1.setP2Morreu(true);
            Player2.setP1Morreu(true);
            if(indice==0)
            {
                Greenfoot.playSound("explosion.mp3");
            }
            setImage(explosao[indice]);
            indice++;
            if(indice>=explosao.length)
            {
                getWorld().removeObject(this);
            }
        }
        contador++;
    }
    
    /**
     * Métodos que registam que o esquimó caiu ao mar
     */
    protected void cair(Esquimó1 morto, GreenfootImage[] animacao){
        if (isTouching(Mar.class)){
            morto.adicionaNumeroVidas(-10);
            Player2.setP1Morreu(true);
            Player1.setP2Morreu(true);
            Jogo3.setP1Chegou(false);
            animacao[indice].setTransparency(animacao[indice].getTransparency()-5);
        }

        if(animacao[indice].getTransparency() <=0){
            getWorld().removeObject(this);
        }
    }
    
    protected void cair(Esquimó2 morto, GreenfootImage[] animacao){
        if (isTouching(Mar.class)){
            morto.adicionaNumeroVidas(-10);
            Player2.setP1Morreu(true);
            Player1.setP2Morreu(true);
            Jogo3.setP2Chegou(false);
            animacao[indice].setTransparency(animacao[indice].getTransparency()-5);
        }

        if(animacao[indice].getTransparency() <=0){
            getWorld().removeObject(this);
        }
    } 

    /**
     * Método que toca um som quando o jogador é atingido por uma bola de granizo
     */
    public void playAtingido()
    {
        atingido.play();
        atingido.setVolume(50);
    }

    /**
     * Método que toca um som quando o jogador apanha um coração de vida
     */
    public void playVida()
    {
        apanhouVida.play();
        apanhouVida.setVolume(30);
    }

    /**
     * Método usado na mudança dos controlos, verifica se a tecla inserida não causa conflito com os outros controlos
     */
    public static boolean podeMudar(String[] P1Controls, String[] P2Controls, String key){
        for (int i=0; i<4;i++){
            if (key.equals(P1Controls[i]) || key.equals(P2Controls[i])){
                return false;
            }
        }
        return true;
    }

}

