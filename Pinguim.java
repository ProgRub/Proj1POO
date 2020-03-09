import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pinguim extends Jogos
{
    private int contador;
    private GreenfootImage[] animacao;
    private boolean caindo;
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
        GreenfootSound som = new GreenfootSound("penguin.mp3");
        som.play();
        som.setVolume(15);
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

    /**
     * Método para animar o pinguim quando este está em cima de uma plataforma de gelo, acenando aos jogadores
     */
    public void animar(){
        if(!caindo){
            contador++;
            if (contador%8==0){
                indice++;
                if (indice>animacao.length-2)
                {
                    indice=1;
                }
                setImage(animacao[indice]);
                contador=0;
            }
        }
    }
    
    /**
     * Método para alterar a posição do objeto (para parecer que está a cair) quando deixa de estar em contacto com uma plataforma de gelo
     * Altera também a variável "caindo", para depois ser utilizada no método caindo() e alterar a animação do objeto
     */

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

    /**
     * Método para alterar a animação do objeto quando está a "cair" (quando a variável caindo é igual a true)
     */
    public void caindo(){
        if(caindo){
            indice=3;
            setImage(animacao[indice]);
            turn(10);
        }
    }
    
    /**
     * Método para remover o objeto quando toca no limite inferior do mundo
     */
    public void desaparece(){
        if (getY() == getWorld().getHeight()-1){
            getWorld().removeObject(this);
        }
    }
}
