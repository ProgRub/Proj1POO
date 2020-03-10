import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EscolhaNomes extends World
{
    private Texto caixa;
    private Texto displayNome;
    private Texto header;
    private String nome;
    private boolean flag;
    private boolean recebeuNomeP1;

    public EscolhaNomes()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("chooseName.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        nome="";
        flag=true;
        recebeuNomeP1=false;
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
        caixa.getImage().setColor(Color.BLACK);
        caixa.getImage().fillRect(0,0,500, 50);
        caixa.getImage().setColor(Color.WHITE);
        caixa.getImage().fillRect(2,2,496, 46);
        addObject(caixa, getWidth()/2, 3*getHeight()/4);
        displayNome = new Texto();
        displayNome.getImage().clear();
        addObject(displayNome, getWidth()/2, 3*getHeight()/4);

        header=new Texto("Player 1,\nwrite your name",50, new Color(255,255,255));
        addObject(header, getWidth()/2, getHeight()/2);
        addObject(new Texto("Max size of 10 characters",25, new Color(255,255,255)),getWidth()/2,3*getHeight()/4-40);
        addObject(new Texto("Press enter to submit",30, new Color(96, 17, 150)),getWidth()/2,3*getHeight()/4+60);
        addObject(new Back(), larg-100, alt-50);
    }

    public void act()
    {
        escritaNome();
    }
    
    /**
     * Método que vai receber as teclas introduzidas pelo utilizador, construindo o nome do jogador e mostrando-o visualmente
     */
    private void escritaNome()
    {
        Greenfoot.getKey(); //discarda a última tecla pressionada
        String key=null;
        while (flag)
        {
            key = Greenfoot.getKey(); 
            if (key!=null){
                if(key.length()<2) //certifica que nao escreve "shift" ou "control"
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
                Options.updateText("Player 2,\nwrite your name", header,50, new Color(255,255,255));
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
        else if (key.equals("escape"))
        {
            getObjects(Back.class).get(0).clickMouse(key);
        }
        Options.updateText(nome, displayNome, 40, Color.BLACK);
        flag=true;
    }
}
