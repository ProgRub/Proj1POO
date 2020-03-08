import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Players
{
    protected static String up;
    protected static String left;
    protected static String right;
    protected static String shoot;
    private static String[] controlos= {up,left,right,shoot};
    protected static String cor;
    protected static String nome;
    private GreenfootImage[] animacao;
    private GreenfootImage[] animacaoDeath;
    protected static int numeroVidas=10;
    protected static int score=0;
    protected static boolean P1morreu;

    public Player2()
    {
        //animação movimento jogador:
        animacao=new GreenfootImage[7];
        animacao[0] = new GreenfootImage(cor+"/Idle.png");      
        for(int i=1; i <animacao.length;i++)
        {
            animacao[i]=new GreenfootImage(cor+"/"+i+".png");
        }
        setImage(animacao[indice]);
        //animação do jogador a "morrer" 
        animacaoDeath = new GreenfootImage[8];
        for(int i=0; i <animacaoDeath.length;i++)
        {
            animacaoDeath[i]=new GreenfootImage(cor+"/Death/"+(i+1)+".png");
        }
        P1morreu=false;
    }

    public void act() 
    {
        queda();
        move();
        disparar();
        perdeVidas(this);
        if(numeroVidas<=0)
        {
            animarMorte(animacaoDeath,andandoParaEsquerda);
        }
    } 

    public static void setP1Morreu(boolean x)
    {
        P1morreu = x;
    }  

    public boolean getAndandoParaEsquerda()
    {
        return andandoParaEsquerda;
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

    public static void adicionaScore(int valor)
    {
        score+=valor;
        if(score<0)
        {
            score-=valor;
        }
    }

    public static String[] getControls(){
        return controlos;
    }

    public static void setControls(int pos, String key){
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

    public static void setColor(String color){
        cor=color;
    }

    public static String getColor(){
        return cor;
    }

    public static int getNumeroVidas()
    {
        return numeroVidas;
    }

    public static void resetNumVidas()
    {
        numeroVidas=10;
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

    /**
     * Método para o movimento do jogador
     */
    protected void move()
    {
        if(numeroVidas > 0 && !P1morreu){
            if (Greenfoot.isKeyDown(up) && podeSaltar){
                saltou=true;
                podeSaltar=false;
            }
            if(saltou){
                jump();
            }
            if (Greenfoot.isKeyDown(left) && !isTouching(Máquina.class)){
                if (!andandoParaEsquerda){
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()-2, getY());
                andandoParaEsquerda=true;
                animarMove(animacao);
            }
            else if (Greenfoot.isKeyDown(right)){
                if (andandoParaEsquerda){
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()+2, getY());
                andandoParaEsquerda=false;
                animarMove(animacao);
            }
            if (!Greenfoot.isKeyDown(right) && !Greenfoot.isKeyDown(up) && !Greenfoot.isKeyDown(left)){
                indice=0;
                setImage(animacao[indice]);
            }
        }
    }

    /**
     * Método que trata da parte da subida do salto
     */
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

    /**
     * Método que trata da parte da queda depois da parte da subida do salto ter sido efetuada
     */
    protected void queda(){
        if (!isTouching(Chão.class) &&!saltou){
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

    /**
     * Método que trata do disparo
     */
    public void disparar(){
        controlBala++;
        if(numeroVidas > 0 && !P1morreu){
            int sentido;
            if(andandoParaEsquerda)
            {
                sentido=-1;
            }
            else
            {
                sentido=1;
            }
            if (controlBala >15 && Greenfoot.isKeyDown(shoot)){
                getWorld().addObject(new Bala(this), getX()+sentido*(2*getImage().getWidth()/3),getY());
                controlBala = 0;
            }
        }
    }

}

