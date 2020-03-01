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
    private GreenfootImage[] animaExplosao = new GreenfootImage[15];
    private int indice=0;
    private boolean explosao=false;

    public Missil(int valor,boolean alvoENave2, Nave1 N1, Nave2 N2)
    {
        limite=valor;
        nave2=N2;
        nave1=N1;
        if (alvoENave2)
        {
            setImage(Player2.getColor()+"/Missil.png");
        }
        else
        {
            setImage(Player1.getColor()+"/Missil.png");
        }
        Nave2EAlvo=alvoENave2;
        getImage().scale(getImage().getWidth()/8, getImage().getHeight()/8);   
        animaExplosao[0] = new GreenfootImage("ExplosionMisseis/1.png");
        animaExplosao[1] = new GreenfootImage("ExplosionMisseis/2.png");
        animaExplosao[2] = new GreenfootImage("ExplosionMisseis/3.png");
        animaExplosao[3] = new GreenfootImage("ExplosionMisseis/4.png");
        animaExplosao[4] = new GreenfootImage("ExplosionMisseis/5.png");
        animaExplosao[5] = new GreenfootImage("ExplosionMisseis/6.png");
        animaExplosao[6] = new GreenfootImage("ExplosionMisseis/7.png");
        animaExplosao[7] = new GreenfootImage("ExplosionMisseis/8.png");
        animaExplosao[8] = new GreenfootImage("ExplosionMisseis/9.png");
        animaExplosao[9] = new GreenfootImage("ExplosionMisseis/10.png");
        animaExplosao[10]= new GreenfootImage("ExplosionMisseis/11.png");
        animaExplosao[11] = new GreenfootImage("ExplosionMisseis/12.png");
        animaExplosao[12] = new GreenfootImage("ExplosionMisseis/13.png");
        animaExplosao[13] = new GreenfootImage("ExplosionMisseis/14.png");
        animaExplosao[14] = new GreenfootImage("ExplosionMisseis/15.png");
        contador=0;
    }

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

    }   

    public void teleguiado(Nave2 alvo){
        if(getY()>limite)
        {
            if (!getWorld().getObjects(Nave2.class).isEmpty())
            {
                turnTowards(alvo.getX(), alvo.getY());
            }
        }
        move(2);
    }    

    public void teleguiado(Nave1 alvo){
        if(getY()>limite)
        {
            if (!getWorld().getObjects(Nave1.class).isEmpty())
            {
                turnTowards(alvo.getX(), alvo.getY());
            }
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
            Player1.adicionaNumeroVidas(-1);
            Player1.adicionaScore(-5);
            setLocation(getX(), getY()-getImage().getHeight());
            explosao=true;
        }
    }

    public void atingiuAlvo(Nave2 alvo)
    {
        if (isTouching(Nave2.class))
        {
            Player2.adicionaNumeroVidas(-1);
            Player2.adicionaScore(-5);
            setLocation(getX(), getY()-getImage().getHeight());
            explosao=true;
        }
    }

    public void animaExplosao()
    {
        if (contador%3==0)
        {
            getImage().clear();
            if(indice==0)
            {
                Greenfoot.playSound("explosion.wav");
            }
            setImage(animaExplosao[indice]);
            indice++;
            if(indice>=animaExplosao.length)
            {
                getWorld().removeObject(this);
            }
        }
        contador++;
    }
}
