import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave2 extends Player2
{
    private GreenfootImage explosao[] = new GreenfootImage[13];
    private int contador;
    private int indice=0;
    
    public Nave2()
    {
        setImage(getColor()+"/Nave.png");
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
        explosao[0] = new GreenfootImage("ExplosionMáquina/1.png");
        explosao[1] = new GreenfootImage("ExplosionMáquina/2.png");
        explosao[2] = new GreenfootImage("ExplosionMáquina/3.png");
        explosao[3] = new GreenfootImage("ExplosionMáquina/4.png");
        explosao[4] = new GreenfootImage("ExplosionMáquina/5.png");
        explosao[5] = new GreenfootImage("ExplosionMáquina/6.png");
        explosao[6] = new GreenfootImage("ExplosionMáquina/7.png");
        explosao[7] = new GreenfootImage("ExplosionMáquina/8.png");
        explosao[8] = new GreenfootImage("ExplosionMáquina/9.png");
        explosao[9] = new GreenfootImage("ExplosionMáquina/10.png");
        explosao[10]= new GreenfootImage("ExplosionMáquina/11.png");
        explosao[11] = new GreenfootImage("ExplosionMáquina/12.png");
        explosao[12] = new GreenfootImage("ExplosionMáquina/13.png");
        contador=0;
    }
    
    public void act() 
    {
        moveNave();
        removeGas();
        perdeVidas(this);
        naveDestruida();
    }    

    public void moveNave(){
        if (Greenfoot.isKeyDown(left)){
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown(right)){
            setLocation(getX()+3, getY());
        }
    }

    public void removeGas()
    {
        if (isTouching (Gas.class))
        {
            Player2.adicionaScore(10);
            removeTouching (Gas.class);

        }
    }
    private void naveDestruida(){
        if (getNumeroVidas() <= 0 && contador%3==0){
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
