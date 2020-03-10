import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuInicial extends World
{
    private static GreenfootSound musica;
    private boolean reset;

    public MenuInicial(boolean resetControlos)
    {    
        super(1200,700, 1); 
        reset=resetControlos;
        GreenfootImage bg = new GreenfootImage("Earth.png");
        musica = new GreenfootSound("music.mp3");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        Greenfoot.setSpeed(50);        
    }

    /**
     * Construtor só usado no inicio da simulação, para definir os controlos que os jogadores podem mudar
     */
    public MenuInicial()
    {    
        super(1200,700, 1); 
        reset=true;
        GreenfootImage bg = new GreenfootImage("Earth.png");
        musica = new GreenfootSound("music.mp3");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
        Greenfoot.setSpeed(50);
    }

    private void prepare()
    {
        addObject(new Play(),getWidth()/2,349);
        addObject(new Options(),getWidth()/2,420);
        addObject(new Exit(),getWidth()/2,462);
        resetStaticVariables();
    }

    /**
     * Método que faz um reset às variáveis static, nomeadamente aquelas relacionadas com os jogadores como os seus controlos, score e número de vidas
     */
    private void resetStaticVariables(){
        if(reset)
        {
            Player1.setControls(0, "w");
            Player1.setControls(1, "a");
            Player1.setControls(2, "d");
            Player1.setControls(3, "f");
            Player2.setControls(0, "up");
            Player2.setControls(1, "left");
            Player2.setControls(2, "right");
            Player2.setControls(3, "0");
        }
        Player1.resetScore();
        Player2.resetScore();
        Player1.resetNumVidas();
        Player2.resetNumVidas();
    }

    /**
     * Método que certifica que a música só toca quando o jogo está a ser executado e não repete
     */
    public void started()
    {
        musica.playLoop();
    }

    public static GreenfootSound getMusica(){
        return musica;
    }
    
    public void stopped()
    {
        musica.stop();
    }
}
