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
    public Jogo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        prepare();
        gameOver = new GameOver();
        restart = new Restart();
        control =false;
        stop =false;
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
    }

    public void act(){
        atualizaVida(máquina.vida);
        gameOver(0,0); //parametros a 0 só para testar
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
}
