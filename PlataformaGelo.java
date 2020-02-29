import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PlataformaGelo extends Jogos
{
    
    private boolean pinguim;
    public PlataformaGelo(){
        podeCriarPinguim();
    }
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
