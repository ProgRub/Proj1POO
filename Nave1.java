import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave1 extends Player1
{   
    private int contador;
    private GreenfootImage explosao[] = new GreenfootImage[13];
    private int indice=0;

    public Nave1()
    {
        setImage(getColor()+"/Nave.png");
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);      
        for(int i=0; i <explosao.length;i++)
        {
            explosao[i]=new GreenfootImage("ExplosionMáquina/"+(i+1)+".png");
        }
        contador=0;
    }

    public void act() 
    {
        moveNave();
        removeGas(); 
        perdeVidas(this);
        naveDestruida();
    } 

    /**
     * Método que trata do movimento da nave
     */
    private void moveNave(){
        if (numeroVidas > 0 && !P2morreu)
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

    /**
     * Método que regista que a nave foi destruída e anima a explosão
     */
    private void naveDestruida(){
        if (numeroVidas <= 0 && contador%3==0){
            Player2.setP1Morreu(true);
            if(indice==0)
            {
                Greenfoot.playSound("explosion.wav");
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

}
