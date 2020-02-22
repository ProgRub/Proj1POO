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
    public Bala(){
        original = getImage();
        setImage(original);
        moveEsquerda= Player1.andandoParaEsquerda;
    }

    public void act() 
    {
        disparo();
        desapareceLimite();
    } 

    public void disparo(){
        if (Player1.andandoParaEsquerda == true){
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
