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
    private GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13;

    public Missil(int valor,Nave2 nave)
    {
        setImage(Player2.getColor()+"/Missil.png");
        getImage().scale(100, 50);   
        limite=valor;
        alvo2=nave;
        
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

    public void atingiuAlvo(Nave2 alvo)
    {
        if (isTouching(Nave2.class))
        {
            alvo.tiraNumeroVidas(-1);
            alvo.tiraNumeroVidas(-1);
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
