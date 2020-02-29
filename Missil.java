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
    private Nave2 nave2=null;
    private Nave1 nave1=null;
    private boolean Nave2EAlvo;
    private int contador;
    private GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13,explosion14,explosion15;
    private boolean explosao=false;

    public Missil(int valor,boolean alvoENave2, Nave1 N1, Nave2 N2)
    {
        limite=valor;
        nave2=N2;
        nave1=N1;
        if (alvoENave2)
        {
            setImage(Player2.getColor()+"/Missil.png");
            getImage().scale(getImage().getWidth()/8, getImage().getHeight()/8);   
            Nave2EAlvo=true;
        }
        else
        {
            setImage(Player1.getColor()+"/Missil.png");
            getImage().scale(getImage().getWidth()/8,getImage().getHeight()/8);  
            Nave2EAlvo=false;
        }
        explosion1 = new GreenfootImage("ExplosionMisseis/1.png");
        explosion2 = new GreenfootImage("ExplosionMisseis/2.png");
        explosion3 = new GreenfootImage("ExplosionMisseis/3.png");
        explosion4 = new GreenfootImage("ExplosionMisseis/4.png");
        explosion5 = new GreenfootImage("ExplosionMisseis/5.png");
        explosion6 = new GreenfootImage("ExplosionMisseis/6.png");
        explosion7 = new GreenfootImage("ExplosionMisseis/7.png");
        explosion8 = new GreenfootImage("ExplosionMisseis/8.png");
        explosion9 = new GreenfootImage("ExplosionMisseis/9.png");
        explosion10 = new GreenfootImage("ExplosionMisseis/10.png");
        explosion11= new GreenfootImage("ExplosionMisseis/11.png");
        explosion12 = new GreenfootImage("ExplosionMisseis/12.png");
        explosion13 = new GreenfootImage("ExplosionMisseis/13.png");
        explosion14 = new GreenfootImage("ExplosionMisseis/14.png");
        explosion15 = new GreenfootImage("ExplosionMisseis/15.png");
        contador=0;
    }

    // public Missil(int valor,Nave1 nave)
    // {
    // limite=valor;
    // nave=nave;    
    // alvoENave2=false;    
    // alvo2=getWorldOfType(Jogo2.class).getObjects(Nave2.class).get(0);
    // explosion1 = new GreenfootImage("ExplosionMisseis/1.png");
    // explosion2 = new GreenfootImage("ExplosionMisseis/2.png");
    // explosion3 = new GreenfootImage("ExplosionMisseis/3.png");
    // explosion4 = new GreenfootImage("ExplosionMisseis/4.png");
    // explosion5 = new GreenfootImage("ExplosionMisseis/5.png");
    // explosion6 = new GreenfootImage("ExplosionMisseis/6.png");
    // explosion7 = new GreenfootImage("ExplosionMisseis/7.png");
    // explosion8 = new GreenfootImage("ExplosionMisseis/8.png");
    // explosion9 = new GreenfootImage("ExplosionMisseis/9.png");
    // explosion10 = new GreenfootImage("ExplosionMisseis/10.png");
    // explosion11= new GreenfootImage("ExplosionMisseis/11.png");
    // explosion12 = new GreenfootImage("ExplosionMisseis/12.png");
    // explosion13 = new GreenfootImage("ExplosionMisseis/13.png");
    // explosion14 = new GreenfootImage("ExplosionMisseis/14.png");
    // explosion15 = new GreenfootImage("ExplosionMisseis/15.png");
    // contador=0;
    // }

    public void act() 
    {
        if(!explosao)
        {
            if (Nave2EAlvo)
            {
                teleguiado(nave2);
                atingiuAlvo(nave2);
                atingiuAlvo(nave1);
                if(!explosao){
                    chegouAoFim();
                }
            }
            else
            {
                teleguiado(nave1);
                atingiuAlvo(nave1);
                atingiuAlvo(nave2);
                if(!explosao){
                    chegouAoFim();
                }
            }
        }
        else
        {
            animaExplosao();
        }

        //chegouAoFim();
        
       
    }   
    


    public void teleguiado(Nave2 alvo){
        if(getY()>limite)
        {
            turnTowards(alvo.getX(), alvo.getY());
        }
        move(2);
    }    

    public void teleguiado(Nave1 alvo){
        if(getY()>limite)
        {
            turnTowards(alvo.getX(), alvo.getY());
        }
        move(2);
    }

    public void chegouAoFim(){
        if(isAtEdge())
        {
            explosao=true;
        }
    }

    public void atingiuAlvo(Nave1 alvo)
    {
        if (isTouching(Nave1.class))
        {
            alvo.tiraNumeroVidas(-1);
            setLocation(getX(), getY()-40);
            explosao=true;
        }
    }

    public void atingiuAlvo(Nave2 alvo)
    {
        if (isTouching(Nave2.class))
        {
            alvo.tiraNumeroVidas(-1);
            setLocation(getX(), getY()-40);
            explosao=true;
        }
    }

    public void animaExplosao()
    {
        if (contador%3==0)
        {
            
            getImage().clear();
            if (getImage() == explosion1)
            {
                Greenfoot.playSound("explosion.wav");
                setImage(explosion2);
            }
            else if (getImage() == explosion2)
            {
                setImage(explosion3);
            }
            else if (getImage() == explosion3)
            {
                setImage(explosion4);
            }
            else if (getImage() == explosion4)
            {
                setImage(explosion5);
            }
            else if (getImage() == explosion5)
            {
                setImage(explosion6);
            }
            else if (getImage() == explosion6)
            {
                setImage(explosion7);
            }
            else if (getImage() == explosion7)
            {
                setImage(explosion8);
            }
            else if (getImage() == explosion8)
            {
                setImage(explosion9);
            }
            else if (getImage() == explosion9)
            {
                setImage(explosion10);
            }
            else if (getImage() == explosion10)
            {
                setImage(explosion11);
            }
            else if (getImage() == explosion11)
            {
                setImage(explosion12);
            }
            else if (getImage() == explosion12)
            {
                setImage(explosion13);
            }
            else if (getImage() == explosion13)
            {
                setImage(explosion14);
            }
            else if (getImage() == explosion14)
            {
                setImage(explosion15);
            }
            else if (getImage() == explosion15)
            {
                getWorld().removeObject(this);
            }
            else 
            {
                setImage(explosion1);                
            }
        }
        contador++;
    }
}
