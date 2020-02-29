import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

<<<<<<< HEAD
/**
 * Write a description of class PlataformaGelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlataformaGelo extends Jogos
{
    /**
     * Act - do whatever the PlataformaGelo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
=======

public class PlataformaGelo extends Jogos
{
    
    private boolean pinguim;
    public PlataformaGelo(){
        podeCriarPinguim();
    }
>>>>>>> 62d88bb920ef8bf4641ee79d5742d33a40b36b44
    public void act() 
    {
        move(-1);
        derreter();
        desaparecer();
        invocaPinguim();
    }    
    
    public void derreter(){
        if (Greenfoot.getRandomNumber(100)<=1){
        getWorld().addObject(new Gota(), getX() + Greenfoot.getRandomNumber(50)-50, getY());
    }
}

public void podeCriarPinguim(){
    if (Greenfoot.getRandomNumber(100)<=20){
        pinguim=true;
    }else{
        pinguim=false;
    }
}
public void invocaPinguim(){
    if (pinguim == true){
        getWorld().addObject(new Pinguim(), getX() + Greenfoot.getRandomNumber(50)-50, getY()-60);
        pinguim = false;
    }
}
    public void desaparecer(){
        if (getX() == 0){
            getWorld().removeObject(this);
        }
    }
}
