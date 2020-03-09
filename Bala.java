import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Players
{
    private GreenfootImage original;
    private boolean moveEsquerda, mudaOrientacao;
    private final int VELOCIDADE;
    private Player1 P1Disparou;
    private Player2 P2Disparou;

    private GreenfootSound disparo;

    public Bala(Player1 P1){
        disparo = new GreenfootSound("gun.mp3");
        original = getImage();
        setImage(original);
        moveEsquerda= P1.getAndandoParaEsquerda();
        disparo.setVolume(70);
        disparo.play();
        VELOCIDADE=8;
        P1Disparou = P1;
        mudaOrientacao = false;
    }

    public Bala(Player2 P2){
        disparo = new GreenfootSound("gun.mp3");
        original = getImage();
        setImage(original);
        moveEsquerda= P2.getAndandoParaEsquerda();
        disparo.setVolume(70);
        disparo.play();
        VELOCIDADE=8;
        P2Disparou = P2;
        mudaOrientacao = false;
    }

    public void act() 
    {
        disparo();
        if(desapareceLimite() ||atingiuMáquina())
        {
            getWorld().removeObject(this);
        }
    } 

    /**
     * Método que movimenta a bala
     */
    private void disparo(){
        if(!mudaOrientacao)
        {
            if (moveEsquerda){
                original = getImage();
                original.mirrorHorizontally();
                setImage(original);
                mudaOrientacao = true;
            }
            else{
                setImage(original);
                mudaOrientacao = true;
            }
        }
        else{
            if (moveEsquerda){
                move(-VELOCIDADE);
            }
            else{
                move(VELOCIDADE);
            }
        }
    }

    private boolean desapareceLimite(){
        if (isAtEdge()){
            return true;
        }
        return false;
    }

    /**
     * Método que regista que a bala atingiu a máquina e adiciona score ao jogador que disparou 
     */
    private boolean atingiuMáquina()
    {
        if (isTouching(Máquina.class) && getWorld().getObjects(Máquina.class).get(0).getVida()>0)
        {
            if (P1Disparou!=null)
            {
                P1Disparou.adicionaScore(10);
            }
            else
            {
                P2Disparou.adicionaScore(10);
            }
            getWorld().getObjects(Máquina.class).get(0).tiraVida(1);
            return true;
        }
        return false;
    }

    public Player1 getP1Disparou()
    {
        return P1Disparou;
    }

    public Player2 getP2Disparou()
    {
        return P2Disparou;
    }
}
