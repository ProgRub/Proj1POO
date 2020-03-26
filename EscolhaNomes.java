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
        //CRIA RETÂNGULO ONDE APARECE O NOME DO JOGADOR:
        int larg=getWidth();
        int alt=getHeight();
        caixa=new Texto();
        caixa.setImage(new GreenfootImage(500, 50));
        caixa.getImage().setColor(Color.BLACK);
        caixa.getImage().fillRect(0,0,500, 50);
        caixa.getImage().setColor(Color.WHITE);
        caixa.getImage().fillRect(2,2,496, 46);
        addObject(caixa, getWidth()/2, 3*getHeight()/4);
        
        //MOSTRA NOME A SER ESCRITO
        displayNome = new Texto();
        displayNome.getImage().clear();
        addObject(displayNome, getWidth()/2, 3*getHeight()/4);

        //TEXTO INFORMATIVO
        header=new Texto("Player 1,\nwrite your name",50, new Color(255,255,255));
        addObject(header, getWidth()/2, getHeight()/2);
        addObject(new Texto("Max size of 10 characters",30, new Color(222, 18, 195)),getWidth()/2,3*getHeight()/4-40);
        addObject(new Texto("Press enter to submit",30, new Color(222, 18, 195)),getWidth()/2,3*getHeight()/4+60);
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
                if(key.length()<2) //certifica que nao escreve "shift" ou "control" ou outra tecla não alfa-numerica
                {
                    nome+=key;
                }
                else if (key.equals("space")) //meter espaço no nome
                {
                    nome+=" ";
                }
                flag=false;
            }

        }
        if (key.equals("enter") || nome.length()>=10) //o utilizador finaliza o seu nome pressionando o enter ou se o tamanho do nome for igual (ou superior) a 10 carateres
        {
            displayNome.updateText(nome,displayNome,40, new Color(0,255,0));
            Greenfoot.delay(25);
            if(!recebeuNomeP1) //define o nome do primeiro jogador e permite receber o do segundo jogador
            {
                Player1.setNome(nome);
                displayNome.updateText("Player 2,\nwrite your name", header,50, new Color(255,255,255));
                nome="";
                recebeuNomeP1=true;
            }
            else //define o nome do segundo jogador e muda o mundo para escolher as cores dos jogadores
            {
                Player2.setNome(nome);
                Greenfoot.setWorld(new EscolherCor());
            }
        }
        else if (key.equals("backspace")) //permite apagar uma letra do nome
        {
            if(nome.length()>0)
            {
                nome=nome.substring(0, nome.length()-1);
            }
        }
        displayNome.updateText(nome, displayNome, 40, Color.BLACK);
        flag=true;
    }
}