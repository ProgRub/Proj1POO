import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pinguim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pinguim extends Jogos
{
    private static int contador;
    private GreenfootImage[] animacao;
    private boolean caindo =false;
    private int indice;
    public Pinguim(){
        animacao = new GreenfootImage[4];
        indice=0;
        animacao[0] = new GreenfootImage("pinguim1.png");
        animacao[1] = new GreenfootImage("pinguim2.png");
        animacao[2] = new GreenfootImage("pinguim3.png");
        animacao[3] = new GreenfootImage("pinguimCaindo.png");
        setImage(animacao[indice]);
        contador=0;
        Greenfoot.playSound("penguin.mp3");
        caindo = false;
    }

    public void act() 
    {
        move(-1);
        animar();
        emCimaPlataforma();
        desaparece();
        caindo();
    } 

    public void animar(){
        if(!caindo){
            contador++;
            if (contador%10==0){
                indice++;
                if (indice>animacao.length-2)
                {
                    indice=0;
                }
                setImage(animacao[indice]);
                contador=0;
            }
        }
    }

    public void emCimaPlataforma(){
        if (!isTouching(PlataformaGelo.class))
        {
            setLocation(getX(), getY() +4);
            caindo=true;
        }
        else if (isTouching(PlataformaGelo.class) && caindo)
        {
            caindo=false;
        }
    }

    public void caindo(){
        if(caindo){
            indice=3;
            setImage(animacao[indice]);
            turn(10);
        }
    }

    public void desaparece(){
        if (getY() == getWorld().getHeight()-1){
            getWorld().removeObject(this);
        }
    }
}
