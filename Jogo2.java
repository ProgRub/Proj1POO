import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo2 extends World
{



    private int LIMITE=100;



    public Jogo2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200,700, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Nave1 nave1 = new Nave1();
        addObject(nave1,getWidth()/2,100);
        Nave2 nave2 = new Nave2();
        addObject(nave2,getWidth()/2,200);
        addObject(new Vida_player1(nave1),260,600);
        addObject(new Vida_player2(nave2),1100,600);
        
        addObject(new CamadaOzono(),getWidth()/2, 20);
    }

    public void act()
    {
        libertarGases();

        vidas();
       
        disparaMissil();
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
        int random = Greenfoot.getRandomNumber(250);
        if (random<2)
        {
            if(random==1)
            {
                addObject(new Missil(getObjects(Nave2.class).get(0).getY()+LIMITE,getObjects(Nave2.class).get(0)), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
            else
            {
                addObject(new Missil(getObjects(Nave1.class).get(0).getY()+LIMITE,getObjects(Nave1.class).get(0)), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
            }
        }
    }
}
