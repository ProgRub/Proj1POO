import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    protected static String up;
    protected static String left;
    protected static String right;
    protected static String shoot;
    private static String[] controlos= {up,left,right,shoot};
    protected static String cor="Red";
    private GreenfootImage image1,image2,image3,image4,image5,image6;
    private int contador;
    private int contador1;
    protected static int score=0;
    private final int GRAVIDADE =15;
    private int tempoJump=GRAVIDADE;
    private int tempoQueda=GRAVIDADE;
    private boolean podeSaltar=false;
    private boolean saltou=false;
    private boolean andandoParaEsquerda;
    private int controlBala;
    protected static int numeroVidas=10;

    public Player1()
    {
        contador=0;
        contador1=0;
        controlBala=0;

        //animação movimento jogador:
        image1 = new GreenfootImage(cor+"/1.png");
        image2 = new GreenfootImage(cor+"/2.png");
        image3 = new GreenfootImage(cor+"/3.png");
        image4 = new GreenfootImage(cor+"/4.png");
        image5 = new GreenfootImage(cor+"/5.png");
        image6 = new GreenfootImage(cor+"/6.png");
        setImage(image4);
        andandoParaEsquerda = false;
    }

    public void act() 
    {
        queda();
        move();
        disparar();        
        perdeVidas(this);
    }

    public static int getScore()
    {
        return score;
    }

    public static void resetScore()
    {
        score=0;
    }

    public static void resetNumVidas()
    {
        numeroVidas=10;
    }
    
    public static void adicionaScore(int valor)
    {
        score+=valor;
        if(score<0)
        {
            score-=valor;
        }
    }

    public boolean getAndandoParaEsquerda()
    {
        return andandoParaEsquerda;
    }

    public static String[] getControls()
    {
        return controlos;
    }

    public static void setControls(int pos, String key)
    {
        controlos[pos]=key;
        switch(pos){
            case 0:
            up=key;
            break;
            case 1:
            left=key;
            break;
            case 2:
            right=key;
            break;
            case 3:
            shoot=key;
            break;
        }

    }

    public static void setColor(String color)
    {
        cor=color;
    }

    public static String getColor(){
        return cor;
    }

    public static int getNumeroVidas()
    {
        return numeroVidas;
    }

    public static void adicionaNumeroVidas(int valor)
    {
        if (valor<0 || (valor > 0 && numeroVidas<9))
        {
            numeroVidas += valor;
        }
        else
        {
            if(numeroVidas<10)
            {
                numeroVidas++;
            }
        }
    }

    public void move()
    {
        if(numeroVidas >0){
            if (Greenfoot.isKeyDown(up) && podeSaltar){
                saltou=true;
                podeSaltar=false;
            }
            if(saltou){
                jump();
            }
            if (Greenfoot.isKeyDown(left)){
                if (!andandoParaEsquerda){
                    image1.mirrorHorizontally();
                    image2.mirrorHorizontally();
                    image3.mirrorHorizontally();
                    image4.mirrorHorizontally();
                    image5.mirrorHorizontally();
                    image6.mirrorHorizontally();
                }
                setLocation(getX()-2, getY());
                andandoParaEsquerda=true;
                animarMove();
            }
            else if (Greenfoot.isKeyDown(right) && !isTouching(Máquina.class)){
                if (andandoParaEsquerda){
                    image1.mirrorHorizontally();
                    image2.mirrorHorizontally();
                    image3.mirrorHorizontally();
                    image4.mirrorHorizontally();
                    image5.mirrorHorizontally();
                    image6.mirrorHorizontally();
                }
                setLocation(getX()+2, getY());
                andandoParaEsquerda=false;
                animarMove();
            }
            if (!Greenfoot.isKeyDown(right) && !Greenfoot.isKeyDown(up) && !Greenfoot.isKeyDown(left)){
                setImage(image4);
            }
        }
    }

    public void jump(){
        if (tempoJump>0){
            setLocation(getX(),getY()-tempoJump);
            tempoJump--;
        }
        else{
            tempoJump=GRAVIDADE;
            saltou=false;
        }
    }

    public void queda(){
        if (!isTouching(Chão.class) && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }
        else{
            tempoQueda=0;
            if(isTouching(Chão.class)){
                podeSaltar=true;
            }
        }
    }

    public void animarMove(){
        contador++;

        if (contador==4){
            if (numeroVidas >0){
                if(getImage()==image1){
                    setImage(image2);
                }
                else if (getImage()==image2){
                    setImage(image3);
                }
                else if(getImage()==image3){
                    setImage(image4);
                }
                else if (getImage()==image4){
                    setImage(image5);
                }
                else if(getImage()==image5){
                    setImage(image6);
                }
                else if (getImage()==image6){
                    setImage(image1);
                }
            }
            contador=0;
        }
    }

    public void disparar(){
        controlBala++;
        //if(numeroVidas >0){
        if (controlBala >20 && Greenfoot.isKeyDown(shoot)){
            getWorld().addObject(new Bala(this), getX(),getY()-5);
            controlBala = 0;
            //}
        }
    }

}
