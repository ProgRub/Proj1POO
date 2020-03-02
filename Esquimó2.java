import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Esquimó2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Esquimó2 extends Player2
{
    private GreenfootImage[] animacao=new GreenfootImage[5];
    private int contador;
    private int indice=0;
    private final int GRAVIDADE =15;
    private int tempoJump=GRAVIDADE;
    private int tempoQueda=GRAVIDADE;
    private boolean podeSaltar=false;
    private boolean saltou=false;
    private boolean andandoParaEsquerda;
    private int transparencia;
    public Esquimó2()
    {
        animacao[0] = new GreenfootImage(cor+"/Jogo3/1.png");
        animacao[1] = new GreenfootImage(cor+"/Jogo3/2.png");
        animacao[2] = new GreenfootImage(cor+"/Jogo3/3.png");
        animacao[3] = new GreenfootImage(cor+"/Jogo3/4.png");
        animacao[4] = new GreenfootImage(cor+"/Jogo3/5.png");
        
        transparencia = 255;
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
            else if (Greenfoot.isKeyDown(right)){
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
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, PlataformaGelo.class);
        if (plat==null   && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }
        else if (plat!=null ){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
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
   
    
    public void cair(){
        
        if (getY() == getWorld().getHeight() - 1){
            numeroVidas -= 2;
            transparencia -= 51;
            for (int i=0; i<5; i++){
                animacao[i].setTransparency(transparencia);
            }
            setLocation(getX(), 0);
        }
        
        if(transparencia <=0){
            getWorld().removeObject(this);
        }
    }
}
