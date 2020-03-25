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
    private static String cor;
    private static String nome;
    private GreenfootImage[] animacao;
    private GreenfootImage[] animacaoDeath;
    private static int numeroVidas=10;
    private static int score=0;
    private static boolean P2morreu;

    public Player1()
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
        P2morreu=false;
    }

    public void act() 
    {
        queda();
        move();
        disparar();        
        perdeVidas(this);
        if(numeroVidas <=0)
        {
            animarMorte(animacaoDeath,andandoParaEsquerda);
        }
    }
    
    public static boolean getP2Morreu()
    {
        return P2morreu;
    }

    public static void setP2Morreu(boolean x)
    {
        P2morreu = x;
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
        if(numeroVidas > 0 &&!P2morreu){
            if (Greenfoot.isKeyDown(up) && podeSaltar){ //certifica que so pode saltar se estiver no chao
                saltou=true;
                podeSaltar=false;
            }
            if(saltou){
                jump();
            }
            if (Greenfoot.isKeyDown(left)){
                if (!andandoParaEsquerda){//reflete as imagens,se necessário
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()-2, getY());
                andandoParaEsquerda=true;
                animarMove(animacao);
            }
            else if (Greenfoot.isKeyDown(right) && !isTouching(Máquina.class)){
                if (andandoParaEsquerda){//reflete as imagens,se necessário
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

    /**
     * Método que trata do disparo
     */
    private void disparar(){
        controlBala++;
        if(numeroVidas > 0 &&!P2morreu){
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