import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


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
    private GreenfootImage[] animacaoDeath=new GreenfootImage[8];
    private int contador;
    private int indice=0;
    private int indiceDeath=0;
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
        setImage(animacao[indice]);
        andandoParaEsquerda = false;

        //animação do jogador a "morrer"
        animacaoDeath[0] = new GreenfootImage(cor+"/Death/1.png");
        animacaoDeath[1] = new GreenfootImage(cor+"/Death/2.png");
        animacaoDeath[2] = new GreenfootImage(cor+"/Death/3.png");
        animacaoDeath[3] = new GreenfootImage(cor+"/Death/4.png");
        animacaoDeath[4] = new GreenfootImage(cor+"/Death/5.png");
        animacaoDeath[5] = new GreenfootImage(cor+"/Death/6.png");
        animacaoDeath[6] = new GreenfootImage(cor+"/Death/7.png");
        animacaoDeath[7] = new GreenfootImage(cor+"/Death/8.png");
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

    protected void move()
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
                indice=0;
                setImage(animacao[indice]);
            }
        }
    }

    protected void jump(){
        if (tempoJump>0){
            setLocation(getX(),getY()-tempoJump);
            tempoJump--;
        }
        else{
            tempoJump=GRAVIDADE;
            saltou=false;
        }
    }

    protected void queda(){
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

    private void animarMove(){
        if (numeroVidas >0){
            contador++;
            if (contador==4){
                if(indice<animacao.length-1)
                {
                    indice++;
                }
                else
                {
                    indice=1;
                }
                setImage(animacao[indice]);
                contador=0;
            }
        }
    }

    private void animarMorte()
    {
        if(numeroVidas <=0)
        {
            if(andandoParaEsquerda)
            {
                for (int i=0; i < animacaoDeath.length;i++)
                {
                    animacaoDeath[i].mirrorHorizontally();
                }
                andandoParaEsquerda=false;
            }
            if(auxDEATH%10==0)
            {
                setImage(animacaoDeath[indiceDeath]);
                indiceDeath++;
                if (indiceDeath>=animacaoDeath.length)
                {
                    getWorld().removeObject(this);
                }
            }
            auxDEATH++;
        }
    }

    private void disparar(){
        controlBala++;
        if(numeroVidas >0){
            if (controlBala >20 && Greenfoot.isKeyDown(shoot)){
                getWorld().addObject(new Bala(this), getX(),getY()-5);
                controlBala = 0;
            }
        }
    }

}
