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
    GreenfootImage pinguim1,pinguim2,pinguim3,pinguimCaindo;
    private boolean caindo =false;
    public Pinguim(){
        pinguim1 = new GreenfootImage("pinguim11.png");
        pinguim2 = new GreenfootImage("pinguim12.png");
        pinguim3 = new GreenfootImage("pinguim13.png");
        pinguimCaindo = new GreenfootImage("pinguimCaindo.png");
        setImage(pinguim1);
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
        if(caindo == false){
            contador++;
            if (contador%10==0){
            if(getImage() == pinguim1){
                setImage(pinguim2);
            }
            else if (getImage() == pinguim2){
                setImage(pinguim3);
            }
            else if (getImage() == pinguim3){
                setImage(pinguim2);
            }else if (getImage() == pinguimCaindo){
                setRotation(0);
                setImage(pinguim1);
            }
        contador=0;
    }
    }
}
    
    public void emCimaPlataforma(){
        if (!isTouching(PlataformaGelo.class)){
            setLocation(getX(), getY() +4);
            caindo=true;
        }else if (isTouching(PlataformaGelo.class) && caindo){
            caindo=false;
        }
    }
    
    public void caindo(){
        if(caindo){
            setImage(pinguimCaindo);
            turn(10);
    }
    }
    
    public void desaparece(){
        if (getY() == getWorld().getHeight()-1){
            getWorld().removeObject(this);
        }
    }
}
