import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo2 extends World
{

<<<<<<< HEAD

   

=======
>>>>>>> c5f74d167766ca7ce36907fe154ae2595bb24b38
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
<<<<<<< HEAD
        addObject(nave1,getWidth()/2,100);


=======
        addObject(nave1,getWidth()/2,50);
        
>>>>>>> c5f74d167766ca7ce36907fe154ae2595bb24b38
        Nave2 nave2 = new Nave2();
        addObject(nave2,getWidth()/2,200);
        addObject(new Vida_player1(nave1),200,600);
        addObject(new Vida_player2(nave2),1000,600);
        
        addObject(new Camada_Ozono(),getWidth()/2, 5);
    }

    public void act()
    {
        libertarGases();
<<<<<<< HEAD


=======
        vidas();
       
>>>>>>> c5f74d167766ca7ce36907fe154ae2595bb24b38
        disparaMissil();



        //vidas();
       

    }
    

    public void libertarGases() 
    {
        if (Greenfoot.getRandomNumber(100)<3)
        {
            addObject(new Gas(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }
<<<<<<< HEAD

    
   public void vidas() 

=======
    
    public void vidas() 
>>>>>>> c5f74d167766ca7ce36907fe154ae2595bb24b38
    {


        if (Greenfoot.getRandomNumber(500)<1)
        {
            addObject(new Vida_jogo2(), Greenfoot.getRandomNumber(getWidth()+1),getHeight());
        }
    }
<<<<<<< HEAD

    
    


    
    
    
    



=======
    
>>>>>>> c5f74d167766ca7ce36907fe154ae2595bb24b38
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
<<<<<<< HEAD

    }  

    }

=======
    }  
}
>>>>>>> c5f74d167766ca7ce36907fe154ae2595bb24b38
 