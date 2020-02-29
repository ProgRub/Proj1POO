import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Players
{
    private GreenfootImage imagem, original;
    private boolean moveEsquerda;
    private final int VELOCIDADE;
    private Player1 P1Disparou;
    private Player2 P2Disparou;

    private GreenfootSound disparo;

    public Bala(Player1 P1){
        disparo = new GreenfootSound("gun.wav");
        original = getImage();
        setImage(original);
        moveEsquerda= P1.getAndandoParaEsquerda();
        disparo.setVolume(70);
        disparo.play();
        VELOCIDADE=8;
        P1Disparou = P1;
    }

    public Bala(Player2 P2){
        disparo = new GreenfootSound("gun.wav");
        original = getImage();
        setImage(original);
        moveEsquerda= P2.getAndandoParaEsquerda();
        disparo.setVolume(70);
        disparo.play();
        VELOCIDADE=8;
        P2Disparou = P2;
    }

    public void act() 
    {
        disparo();
        if(desapareceLimite() ||atingiuMáquina())
        {
            getWorld().removeObject(this);
        }
    } 

    private void disparo(){
        if (moveEsquerda){
            imagem = getImage();
            imagem.mirrorHorizontally();
            setImage(imagem);
        }
        else{
            setImage(original);
        }
        if (moveEsquerda){
            move(-VELOCIDADE);
        }
        else{
            move(VELOCIDADE);
        }
    }

    private boolean desapareceLimite(){
        if (isAtEdge()){
            return true;
        }
        return false;
    }

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
            getWorldOfType(Jogo1.class).getObjects(VidaMáquina.class).get(0).perdeVida();
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
