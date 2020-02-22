;import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Máquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Máquina extends Actor
{           
    public int vida,score;
    public Máquina(){
        vida=100;
        score=0;
    }

    public void act() 
    {
        // Add your action code here.
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
        if (isTouching(Bala.class)){
            removeTouching(Bala.class);
            vida--;
        }
    }

    public void maquinaDestruida(){
        if (vida == 0){
            getWorld().removeObject(this);
        }
    }
}
