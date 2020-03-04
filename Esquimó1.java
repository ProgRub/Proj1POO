import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Esquimó1 extends Player1
{
    private GreenfootImage[] animacao=new GreenfootImage[5];
    private int contador;
    private int indice;
    private final int GRAVIDADE =15;
    private int tempoJump=GRAVIDADE;
    private int tempoQueda=0;
    private boolean podeSaltar=false;
    private boolean saltou=false;
    private boolean andandoParaEsquerda;
    private static boolean P2morreu;

    public Esquimó1()
    {
        animacao[0] = new GreenfootImage(cor+"/Jogo3/1.png");
        animacao[1] = new GreenfootImage(cor+"/Jogo3/2.png");
        animacao[2] = new GreenfootImage(cor+"/Jogo3/3.png");
        animacao[3] = new GreenfootImage(cor+"/Jogo3/4.png");
        animacao[4] = new GreenfootImage(cor+"/Jogo3/5.png");
        P2morreu=false;
        contador=0;
        indice=0;
    }

    public void act() 
    {
        queda();
        move();
        salvarPinguim();
        cair();
    }

    protected void move()
    {
        if(numeroVidas >0 &&!P2morreu){
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
                setLocation(getX()-3, getY());
                andandoParaEsquerda=true;
                animarMove();
            }
            else if (Greenfoot.isKeyDown(right) ){
                if (andandoParaEsquerda){
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()+3, getY());
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
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, PlataformaGelo.class);
        if (plat==null  && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }
        else if (plat!=null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            if (plat instanceof Plataforma_Final)
            {
                Jogo3.setP1Chegou(true);
            }
        }
        plat=null;
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

    public static void setP2Morreu(boolean x)
    {
        P2morreu = x;
    }

    public void cair(){
        if (intersects(getWorld().getObjects(Mar.class).get(0))){
            numeroVidas -= 10;
            Esquimó2.setP1Morreu(true);
            saltou=true;
            animacao[indice].setTransparency(animacao[indice].getTransparency()-5);
        }

        if(animacao[indice].getTransparency() <=0){
            getWorld().removeObject(this);
        }
    }
    
    public void salvarPinguim()
    {
        if (isTouching(Pinguim.class))
        {
            Player1.adicionaScore(50);
            removeTouching(Pinguim.class);
        }
    }
}
