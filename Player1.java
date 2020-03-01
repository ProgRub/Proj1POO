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
    protected static String cor;
    protected static String nome;
    private GreenfootImage[] animacao=new GreenfootImage[7];
    private GreenfootImage image1DEATH, image2DEATH,image3DEATH,image4DEATH,image5DEATH,image6DEATH, image7DEATH, image8DEATH;
    private int contador;
    private int indice=0;
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
    private int auxDEATH;

    public Player1()
    {
        contador=0;
        contador1=0;
        controlBala=0;

        //animação movimento jogador:
        animacao[0] = new GreenfootImage(cor+"/Idle.png");
        animacao[1] = new GreenfootImage(cor+"/1.png");
        animacao[2] = new GreenfootImage(cor+"/2.png");
        animacao[3] = new GreenfootImage(cor+"/4.png");
        animacao[4] = new GreenfootImage(cor+"/4.png");
        animacao[5] = new GreenfootImage(cor+"/5.png");
        animacao[6] = new GreenfootImage(cor+"/6.png");
        setImage(animacao[0]);
        andandoParaEsquerda = false;
        
        //animação do jogador a "morrer"
        image1DEATH = new GreenfootImage(cor+"/Death/1.png");
        image2DEATH = new GreenfootImage(cor+"/Death/2.png");
        image3DEATH = new GreenfootImage(cor+"/Death/3.png");
        image4DEATH = new GreenfootImage(cor+"/Death/4.png");
        image5DEATH = new GreenfootImage(cor+"/Death/5.png");
        image6DEATH = new GreenfootImage(cor+"/Death/6.png");
        image7DEATH = new GreenfootImage(cor+"/Death/7.png");
        image8DEATH = new GreenfootImage(cor+"/Death/8.png");
        auxDEATH = 0;
        
    }

    public void act() 
    {
        queda();
        move();
        disparar();        
        perdeVidas(this);
        animarMorte();
    }

    public static String getNome()
    {
        return nome;
    }

    public static void setNome(String texto)
    {
        nome=texto;
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
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()-2, getY());
                andandoParaEsquerda=true;
                animarMove();
            }
            else if (Greenfoot.isKeyDown(right) && !isTouching(Máquina.class)){
                if (andandoParaEsquerda){
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()+2, getY());
                andandoParaEsquerda=false;
                animarMove();
            }
            if (!Greenfoot.isKeyDown(right) && !Greenfoot.isKeyDown(up) && !Greenfoot.isKeyDown(left)){
                setImage(animacao[0]);
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
                if(indice<6)
                {
                    indice++;
                }
                else
                {
                    indice=1;
                }
                setImage(animacao[indice]);
            }
            contador=0;
        }
    }
    
    
    public void animarMorte()
    {
        if(numeroVidas == 0 || numeroVidas<0)
        {
            if(auxDEATH==0 && andandoParaEsquerda == false)
            {
                setImage(image1DEATH);
            }
            
            if(auxDEATH==0 && andandoParaEsquerda == true)
            {
                image1DEATH.mirrorHorizontally();
                setImage(image1DEATH);
            }
            
            if(auxDEATH==15 && andandoParaEsquerda == false)
            {
                setImage(image2DEATH);
            }
            
            if(auxDEATH==15 && andandoParaEsquerda == true)
            {
                image2DEATH.mirrorHorizontally();
                setImage(image2DEATH);
            }
            
            if(auxDEATH==30 && andandoParaEsquerda == false)
            {
                setImage(image3DEATH);
            }
            
            if(auxDEATH==30 && andandoParaEsquerda == true)
            {
                image3DEATH.mirrorHorizontally();
                setImage(image3DEATH);
            }
            
            if(auxDEATH==30 && andandoParaEsquerda == false)
            {
                setImage(image4DEATH);
            }
            
            if(auxDEATH==30 && andandoParaEsquerda == true)
            {
                image4DEATH.mirrorHorizontally();
                setImage(image4DEATH);
            }
            
            if(auxDEATH==45 && andandoParaEsquerda == false)
            {
                setImage(image5DEATH);
            }
            
            if(auxDEATH==45 && andandoParaEsquerda == true)
            {
                image5DEATH.mirrorHorizontally();
                setImage(image5DEATH);
            }
            
            if(auxDEATH==60 && andandoParaEsquerda == false)
            {
                setImage(image6DEATH);
            }
            
            if(auxDEATH==60 && andandoParaEsquerda == true)
            {
                image6DEATH.mirrorHorizontally();
                setImage(image6DEATH);
            }
            
            if(auxDEATH==75 && andandoParaEsquerda == false)
            {
                setImage(image7DEATH);
            }
            
            if(auxDEATH==75 && andandoParaEsquerda == true)
            {
                image7DEATH.mirrorHorizontally();
                setImage(image7DEATH);
            }
            
            
           if(auxDEATH==90 && andandoParaEsquerda == false)
            {
                setImage(image8DEATH);
            }
            
            if(auxDEATH==90 && andandoParaEsquerda == true)
            {
                image8DEATH.mirrorHorizontally();
                setImage(image8DEATH);
            }
            
            auxDEATH++;
            
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
