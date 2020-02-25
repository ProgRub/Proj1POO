import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missil extends Jogos
{
    /**
     * Act - do whatever the Missil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int limite;
    private Nave2 alvo2=null;
    private Nave1 alvo1=null;

    public Missil(int valor,Nave2 nave)
    {
        setImage(Player2.getColor()+"/Missil.png");
        getImage().scale(100, 50);   
        limite=valor;
        alvo2=nave;
    }

    public Missil(int valor,Nave1 nave)
    {
        setImage(Player1.getColor()+"/Missil.png");
        getImage().scale(100, 50);     
        limite=valor;
        alvo1=nave;
    }

    public void act() 
    {
        if (alvo2!=null)
        {
            teleguiado(alvo2);
        }
        else
        {
            teleguiado(alvo1);
        }
        chegouAoFim();
    }    

    public void teleguiado(Nave2 alvo){
        if(getY()>limite)
        {
            turnTowards(alvo.getX(), alvo.getY());
        }
        move(3);
    }    

    public void teleguiado(Nave1 alvo){
        if(getY()>limite)
        {
            turnTowards(alvo.getX(), alvo.getY());
        }
        move(3);
    }

    public void chegouAoFim(){
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }

    public void atingiuAlvo(Nave1 alvo)
    {
        if (isTouching(Nave1.class))
        {
            alvo.tiraNumeroVidas(-1);
            getWorld().removeObject(this);
        }            
    }

    public void atingiuAlvo(Nave2 alvo)
    {
        if (isTouching(Nave2.class))
        {
            alvo.tiraNumeroVidas(-1);
            getWorld().removeObject(this);
        }            
    }
}
