import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EscolherJogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EscolhaNomes extends World
{

    /**
     * Constructor for objects of class EscolherJogo.
     * 
     */
    private Texto caixa;
    private Texto displayNome;
    private Texto header;
    private String nome="";
    private boolean flag=true;
    private boolean recebeuNomeP1=false;
    public EscolhaNomes()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("chooseName.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare(); 
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    {
        int larg=getWidth();
        int alt=getHeight();
        caixa=new Texto();
        caixa.setImage(new GreenfootImage(500, 50));
        caixa.getImage().setColor(Color.WHITE);
        caixa.getImage().fillRect(0,0,500, 50);
        addObject(caixa, getWidth()/2, 3*getHeight()/4);
        displayNome = new Texto();
        displayNome.getImage().clear();
        addObject(displayNome, getWidth()/2, 3*getHeight()/4);
<<<<<<< Updated upstream
        header=new Texto("Player 1,\nwrite your name",60, new Color(255,255,0));
        addObject(header, getWidth()/2, getHeight()/2);
        addObject(new Texto("Max size of 10 characters",30, new Color(255,0,0)),getWidth()/2,3*getHeight()/4-40);
        addObject(new Texto("Press enter to submit",30, new Color(255,0,0)),getWidth()/2,3*getHeight()/4+40);
=======
        header=new Texto("Player 1,\nenter your name:",50, new Color(255,255,255));
        addObject(header, getWidth()/2, getHeight()/2);
        addObject(new Texto("Maximum characters: 10",30, new Color(200, 8, 16)),getWidth()/2,3*getHeight()/4-40);
        addObject(new Texto("Press 'ENTER' to submit.",30, new Color(200, 8, 16)),getWidth()/2,3*getHeight()/4+40);
>>>>>>> Stashed changes
    }

    public void act()
    {
        escritaNome();
        Options.updateText(nome, displayNome, 40, Color.BLACK);
    }

    private void escritaNome()
    {
        Greenfoot.getKey();
        String key=null;
        while (flag)
        {
            key =Greenfoot.getKey();
            if (key!=null){
                if(key.length()<2)
                {
                    nome+=key;
                }
                else if (key.equals("space"))
                {
                    nome+=" ";
                }
                flag=false;
            }
        }
        if (key.equals("enter") || nome.length()>=10)
        {
            Options.updateText(nome,displayNome,40, new Color(0,255,0));
            Greenfoot.delay(25);
            if(!recebeuNomeP1)
            {
                Player1.setNome(nome);
<<<<<<< Updated upstream
                Options.updateText("Player 2,\nwrite your name", header,60, new Color(255,255,0));
=======
                Options.updateText("Player 2,\nenter your name:", header,50, new Color(255,255,255));
>>>>>>> Stashed changes
                nome="";
                recebeuNomeP1=true;
            }
            else
            {
                Player2.setNome(nome);
                Greenfoot.setWorld(new EscolherCor());
            }
        }
        else if (key.equals("backspace"))
        {
            if(nome.length()>0)
            {
                nome=nome.substring(0, nome.length()-1);
            }
        }
        flag=true;
    }
}
