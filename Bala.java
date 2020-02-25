import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    private GreenfootImage imagem, original;
    private boolean moveEsquerda;
    private final int VELOCIDADE;
    
    private GreenfootSound disparo;
    
    public Bala(Player1 P1){
        disparo = new GreenfootSound("gun.wav");
        original = getImage();
        setImage(original);
        moveEsquerda= P1.andandoParaEsquerda;
        disparo.setVolume(70);
        disparo.play();
        VELOCIDADE=8;
    }
    public Bala(Player2 P2){
        disparo = new GreenfootSound("gun.wav");
        original = getImage();
        setImage(original);
        moveEsquerda= P2.andandoParaEsquerda;
        disparo.setVolume(70);
        disparo.play();
        VELOCIDADE=8;
    }

    public void act() 
    {
        disparo();
        desapareceLimite();
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

    private void desapareceLimite(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
