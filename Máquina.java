import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Máquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Máquina extends Actor
{           
    public static int vida,score;
    private GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13;
    private VidaMáquina vidaMáquina;
    public Máquina(){
        vida=500;
        score=0;
        explosion1 = new GreenfootImage("Explosion/1.png");
        explosion2 = new GreenfootImage("Explosion/2.png");
        explosion3 = new GreenfootImage("Explosion/3.png");
        explosion4 = new GreenfootImage("Explosion/4.png");
        explosion5 = new GreenfootImage("Explosion/5.png");
        explosion6 = new GreenfootImage("Explosion/6.png");
        explosion7 = new GreenfootImage("Explosion/7.png");
        explosion8 = new GreenfootImage("Explosion/8.png");
        explosion9 = new GreenfootImage("Explosion/9.png");
        explosion10 = new GreenfootImage("Explosion/10.png");
        explosion11= new GreenfootImage("Explosion/11.png");
        explosion12 = new GreenfootImage("Explosion/12.png");
        explosion13 = new GreenfootImage("Explosion/13.png");

    }

    public void act() 
    {
        libertGas();
        perdeVida();
        maquinaDestruida();
    }   

    private void libertGas(){
        if (Greenfoot.getRandomNumber(100)>97){
            Máquina maq = getWorld().getObjects(Máquina.class).get(0);
            getWorld().addObject(new Gas(),maq.getX()+Greenfoot.getRandomNumber(40)-10, maq.getY() - maq.getImage().getHeight()/2);
        }
    }

    private void perdeVida(){
        if (isTouching(Bala.class)){
            removeTouching(Bala.class);
            vida--;
            getWorldOfType(Jogo1.class).getVidaMáquina().perdeVida();
        }
    }


    private void maquinaDestruida(){
        if (vida <= 0){
            Greenfoot.playSound("explosion.wav");
            Greenfoot.delay(3);
            setImage(explosion1);
            Greenfoot.delay(1);
            setImage(explosion2);
            Greenfoot.delay(1);
            setImage(explosion3);
            Greenfoot.delay(1);
            setImage(explosion4);
            Greenfoot.delay(1);
            setImage(explosion5);
            Greenfoot.delay(1);
            setImage(explosion6);
            Greenfoot.delay(1);
            setImage(explosion7);
            Greenfoot.delay(1);
            setImage(explosion8);
            Greenfoot.delay(1);
            setImage(explosion9);
            Greenfoot.delay(1);
            setImage(explosion10);
            Greenfoot.delay(1);
            setImage(explosion11);
            Greenfoot.delay(1);
            setImage(explosion12);
            Greenfoot.delay(1);
            setImage(explosion13);
            Greenfoot.delay(1);
            getWorld().removeObject(this);
        }
    }
}
