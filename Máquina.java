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
    GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13;
    VidaMáquina vidaMáquina;
    public Máquina(){
        vida=1000;
        score=0;
        explosion1 = new GreenfootImage("explosion1.png");
        explosion2 = new GreenfootImage("explosion2.png");
        explosion3 = new GreenfootImage("explosion3.png");
        explosion4 = new GreenfootImage("explosion4.png");
        explosion5 = new GreenfootImage("explosion5.png");
        explosion6 = new GreenfootImage("explosion6.png");
        explosion7 = new GreenfootImage("explosion7.png");
        explosion8 = new GreenfootImage("explosion8.png");
        explosion9 = new GreenfootImage("explosion9.png");
        explosion10 = new GreenfootImage("explosion10.png");
        explosion11= new GreenfootImage("explosion11.png");
        explosion12 = new GreenfootImage("explosion12.png");
        explosion13 = new GreenfootImage("explosion13.png");

    }

    public void act() 
    {
        libertGas();
        perdeVida();
        maquinaDestruida();
    }   

    public void libertGas(){
        if (Greenfoot.getRandomNumber(100)>97){
            Máquina maq = getWorld().getObjects(Máquina.class).get(0);
            getWorld().addObject(new Gas(),maq.getX()+Greenfoot.getRandomNumber(40)-10, maq.getY() - maq.getImage().getHeight()/2);
        }
    }

    public void perdeVida(){
        World myWorld = getWorld();
        Jogo1 jogo1 = (Jogo1)myWorld;
        vidaMáquina = jogo1.getVidaMáquina();
        if (isTouching(Bala.class)){
            removeTouching(Bala.class);
            vida--;
            vidaMáquina.perdeVida();
        }
    }


    public void maquinaDestruida(){
        if (vida == 0){
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
