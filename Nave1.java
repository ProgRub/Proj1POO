import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nave1 extends Player1
{   
    private GreenfootImage[] explosao;

    public Nave1()
    {
        setImage(getColor()+"/Nave.png");
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
        explosao = new GreenfootImage[13];
        for(int i=0; i <explosao.length;i++)
        {
            explosao[i]=new GreenfootImage("ExplosionMáquina/"+(i+1)+".png");
        }
    }

    public void act() 
    {
        moveNave();
        removeGas(); 
        perdeVidas(this);
        if(getNumeroVidas()<=0)
        {
            naveDestruida(explosao);
        }
    } 

    /**
     * Método que trata do movimento da nave
     */
    private void moveNave(){
        if (getNumeroVidas() > 0 && !getP2Morreu())
        {
            if (Greenfoot.isKeyDown(left)){
                setLocation(getX()-3, getY());
            }
            else if (Greenfoot.isKeyDown(right)){
                setLocation(getX()+3, getY());
            }
        }
    }

    /**
     * Método que trata de registar que a nave "apanhou" o gás, dando ao jogador 10 de pontuação
     */
    private void removeGas()
    {
        if (isTouching(Gas.class))
        {
            Player1.adicionaScore(10);
            removeTouching(Gas.class);

        }
    }
}