import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogo1 extends World
{
    GameOver gameOver;
    Restart restart;
    public Máquina máquina;
    public boolean control,stop;
    
    
    static public Player1 player__1;
    static public Player2 player__2;
    
    private Vida_5 player10, player_10;
    private Vida_4_e_meio player9, player_9;
    private Vida_4 player8, player_8;
    private Vida_3_e_meio player7, player_7;
    private Vida_3 player6, player_6;
    private Vida_2_e_meio player5, player_5;
    private Vida_2 player4, player_4;
    private Vida_1_e_meio player3, player_3;
    private Vida_1  player2, player_2;
    private Vida_0_e_meio player1, player_1;
    
    
    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        prepare();
        gameOver = new GameOver();
        restart = new Restart();
        control =false;
        stop =false;
        
        
        
        
        player1 = new Vida_0_e_meio();
        player_1 = new Vida_0_e_meio();
        player2 = new Vida_1();
        player_2 = new Vida_1();
        player3 = new Vida_1_e_meio();
        player_3 = new Vida_1_e_meio();
        player4 = new Vida_2();
        player_4 = new Vida_2();
        player5 = new Vida_2_e_meio();
        player_5 = new Vida_2_e_meio();
        player6 = new Vida_3();
        player_6 = new Vida_3();
        player7 = new Vida_3_e_meio();
        player_7 = new Vida_3_e_meio();
        player8 = new Vida_4();
        player_8 = new Vida_4();
        player9 = new Vida_4_e_meio();
        player_9 = new Vida_4_e_meio();
        player10 = new Vida_5();
        player_10 = new Vida_5();
        
        
        player__1 = new Player1();
        player__2 = new Player2();
        
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        máquina = new Máquina();
        addObject(máquina,getWidth()/2,getHeight()-150);
        Player1 P1 = new Player1();
        addObject(P1,getWidth()/10,getHeight()-100);
        Player2 P2 = new Player2();
        addObject(P2,(9*getWidth())/10,getHeight()-100);

        VidaMáquina vidaMáquina = new VidaMáquina();
        addObject(vidaMáquina,560,32);
        vidaMáquina.setLocation(getWidth()/2,40);
        P1.setLocation(120,620);
        P2.setLocation(1080,620);
    }

    public void act(){
        atualizaVida(máquina.vida);
        gameOver(100,100); //parametros a 0 só para testar
        
        cairGranizo();
        atualizaVidasPlayer1(player__1.numeroVidas);
        atualizaVidasPlayer2(player__2.numeroVidas);
    }

    private void atualizaVida(int vidaAtualizada){
        showText("" + vidaAtualizada + "%", getWidth()/2,getHeight()-190);
    }
    
    private void gameOver(int vidaJogador1, int vidaJogador2){
        if (vidaJogador1 ==0 && vidaJogador2 == 0 && control == false ){
            addObject(gameOver,getWidth()/2,getHeight()/2);
            addObject(restart,getWidth()/2,getHeight()/2 +50);
            stop =true;
            if (stop == true){
                Greenfoot.playSound("gameOver.mp3");
                control =true;
                stop =false;
            }
        }
        if (vidaJogador1 ==0 && vidaJogador2 == 0){
            showText("", getWidth()/2,getHeight()-190); //apagar % de vida
        }
    }
    
    
    public void cairGranizo() 
    {
         
        if (Greenfoot.getRandomNumber(100)<3)
        {
            addObject(new Granizo(), Greenfoot.getRandomNumber(getWidth()-1),0);
        }
    }
        
    
    
    private void atualizaVidasPlayer1(int aux)
    {   
        if(aux == 10)
        {
            addObject(player10,350,100);
        }
        
        
        if(aux == 9)
        {
            removeObject(player10);
            addObject(player9,350,300);
            
        }
        
        if(aux == 8)
        {
            removeObject(player9);
            addObject(player8,350,100);
        }
        
        if(aux == 7)
        {
            removeObject(player8);
            addObject(player7,350,100);
        }
        
        if(aux == 6)
        {
            removeObject(player7);
            addObject(player6,350,100);
        }
        
        if(aux == 5)
        {
            removeObject(player6);
            addObject(player5,350,100);
        }
        
        if(aux == 4)
        {
            removeObject(player5);
            addObject(player4,350,100);
        }
        
        if(aux == 3)
        {
            removeObject(player4);
            addObject(player3,350,100);
        }
        
        if(aux == 2)
        {
            removeObject(player3);
            addObject(player2,350,100);
        }
        
        if(aux == 1)
        {
            removeObject(player2);
            addObject(player1,350,100);
        }
        
        if(aux == 0)
        {
            removeObject(player1);
            Greenfoot.stop();
        }
                
        
    }
    
    
    
    private void atualizaVidasPlayer2(int aux)
    {   
        if(aux == 10)
        {
            addObject(player_10,1050,100);
        }
        
        if(aux == 9)
        {
            removeObject(player_10);
            addObject(player_9,1050,100);
        }
        
        if(aux == 8)
        {
            removeObject(player_9);
            addObject(player_8,1050,100);
        }
        
        if(aux == 7)
        {
            removeObject(player_8);
            addObject(player_7,1050,100);
        }
        
        if(aux == 6)
        {
            removeObject(player_7);
            addObject(player_6,1050,100);
        }
        
        if(aux == 5)
        {
            removeObject(player_6);
            addObject(player_5,1050,100);
        }
        
        if(aux == 4)
        {
            removeObject(player_5);
            addObject(player_4,1050,100);
        }
        
        if(aux == 3)
        {
            removeObject(player_4);
            addObject(player_3,1050,100);
        }
        
        if(aux == 2)
        {
            removeObject(player_3);
            addObject(player_2,1050,100);
        }
        
        if(aux == 1)
        {
            removeObject(player_2);
            addObject(player_1,1050,100);
        }
        
        if(aux == 0)
        {
            removeObject(player_1);
            Greenfoot.stop();
        }
                
        
    }
    
}
