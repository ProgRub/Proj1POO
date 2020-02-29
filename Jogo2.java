import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo2 extends World
{
    private int LIMITE=200;
    GameOver gameOver;
    Restart restart;
    private boolean control,stop;
    Nave1 nave1;
    Nave2 nave2;
    CamadaOzono camadaOzono;

    public Jogo2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,700, 1); 
        prepare();
        gameOver = new GameOver();
        restart = new Restart();
        control =false;
        stop =false;
    }

    private void prepare()
    {
        nave1 = new Nave1();
        addObject(nave1,getWidth()/2,100);
        nave2 = new Nave2();

        addObject(nave2,getWidth()/2,200);
        addObject(new Vida_player1(),285/2,600);
        addObject(new Vida_player2(),getWidth()-285/2,600);

        camadaOzono= new CamadaOzono();
        addObject(camadaOzono,getWidth()/2, 20);

        addObject(new VidaCamadaOzono(), getWidth()/2, 600);
        setPaintOrder(GameOver.class, Restart.class, CamadaOzono.class);
    }

    public void act()
    {
        showText(""+Player1.getScore(), 285/2, 650);
        showText(""+Player2.getScore(), getWidth()-285/2, 650);
        libertarGases();        
        disparaMissil();
        vidas();        
        gameOver(camadaOzono.getVida(), nave1.getNumeroVidas(), nave2.getNumeroVidas());

    }

    public void libertarGases() 
    {
        if (Greenfoot.getRandomNumber(100)<3)
        {
            addObject(new Gas(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }

    
    public void vidas() 

    {
        if (Greenfoot.getRandomNumber(500)<1)
        {
            addObject(new Vida_jogo2(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }


    

    public void disparaMissil(){
        int random = Greenfoot.getRandomNumber(400);
        if (random<2)
        {
            if(random==1)
            {
                addObject(new Missil(getObjects(Nave2.class).get(0).getY()+LIMITE,true,getObjects(Nave1.class).get(0),getObjects(Nave2.class).get(0)), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
            else
            {
                addObject(new Missil(getObjects(Nave1.class).get(0).getY()+LIMITE,false,getObjects(Nave1.class).get(0),getObjects(Nave2.class).get(0)), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
        }
    }

    private void gameOver(int vidaCamada, int vidaNave1, int vidaNave2){
        if ( ((vidaNave1 <=0 && vidaNave2 <= 0 ) || vidaCamada <=0) && control == false){
            addObject(gameOver,getWidth()/2,getHeight()/2);
            addObject(restart,getWidth()/2,getHeight()/2 +150);
            stop =true;
            if (stop == true){
                Greenfoot.playSound("gameOver.mp3");
                control =true;
                stop =false;
            }
        }

    }

}  


