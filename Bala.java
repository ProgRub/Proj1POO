import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    GreenfootImage imagem, original;
    private boolean moveEsquerda;
    
    GreenfootSound disparo = new GreenfootSound("gun.wav");
    
    public Bala(Player1 P1){
        original = getImage();
        setImage(original);
        moveEsquerda= P1.andandoParaEsquerda;
        disparo.setVolume(70);
        disparo.play();
    }
    public Bala(Player2 P2){
        original = getImage();
        setImage(original);
        moveEsquerda= P2.andandoParaEsquerda;
        disparo.setVolume(70);
        disparo.play();
    }

    public void act() 
    {
        disparo();
        desapareceLimite();
    } 

    public void disparo(){
        if (moveEsquerda){
            imagem = getImage();
            imagem.mirrorHorizontally();
            setImage(imagem);
        }
        else{
            setImage(original);
        }
        if (moveEsquerda){
            move(-8);
        }
        else{
            move(8);
        }
    }

    public void desapareceLimite(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
