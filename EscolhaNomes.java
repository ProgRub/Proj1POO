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
    private String nome="";
    private boolean flag=true;
    private boolean recebeuNomeP1=false;
    public EscolhaNomes()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
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
    }

    public void act()
    {
        escritaNome();
        Options.updateText(nome, displayNome, 40, Color.BLACK);
    }

    private void escritaNome()
    {
        Greenfoot.getKey();
        Greenfoot.delay(1);
        while (flag)
        {
            String key =Greenfoot.getKey();
            if (key!=null){
                if( key.length()<2)
                {
                    nome+=key;
                }
                else if (key.equals("backspace"))
                {
                    nome=nome.substring(0, nome.length()-1);
                }
                else if (key.equals("space"))
                {
                    nome+=" ";
                }
                else if (key.equals("enter"))
                {
                    if(!recebeuNomeP1)
                    {
                        Player1.setNome(nome);
                        System.out.println(Player1.getNome());
                        nome="";
                    }
                    else
                    {
                        Player2.setNome(nome);
                        System.out.println(Player2.getNome());
                    }
                }

                flag=false;
            }
        }
        flag=true;
    }
}