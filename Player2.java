import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Players
{

    private static String up;
    private static String left;
    private static String right;
    private static String down;
    private static String shoot;
    private static String[] controlos= {up,left,right,down,shoot};
    private static String cor="";
    private GreenfootImage image1,image2,image3,image4,image5,image6;
    private int contador=0;
    private final int GRAVIDADE =15;
    private int tempoJump=GRAVIDADE;
    private int tempoQueda=GRAVIDADE;
    private boolean podeSaltar=false;
    private boolean saltou=false;
    public static boolean andandoParaEsquerda;
    private int controlBala=0;
    private static int numeroVidas;

    public Player2()
    {
        image1 = new GreenfootImage(cor+"/1.png");
        image2 = new GreenfootImage(cor+"/2.png");
        image3 = new GreenfootImage(cor+"/3.png");
        image4 = new GreenfootImage(cor+"/4.png");
        image5 = new GreenfootImage(cor+"/5.png");
        image6 = new GreenfootImage(cor+"/6.png");
        setImage(image4);
        andandoParaEsquerda = false;
        numeroVidas = 10;
    }

    public void act() 
    {
        queda();
        move();
        disparar();
        perdeVidas(this);
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
            down=key;
            break;
            case 4:
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

    public static void adicionaNumeroVidas(int valor)
    {
        numeroVidas += valor;
    }  

    public void move(){
        if(numeroVidas >0){
            if (Greenfoot.isKeyDown(up) && podeSaltar){
                saltou=true;
                podeSaltar=false;
            }
            if(saltou){
                jump();
            }
            if (Greenfoot.isKeyDown(left)&&!isTouching(Máquina.class)){
                if (!andandoParaEsquerda){
                    image1.mirrorHorizontally();
                    image2.mirrorHorizontally();
                    image3.mirrorHorizontally();
                    image4.mirrorHorizontally();
                    image5.mirrorHorizontally();
                    image6.mirrorHorizontally();
                }
                setLocation(getX()-2, getY());
                animarMove();
                andandoParaEsquerda=true;
            }
            else if (Greenfoot.isKeyDown(right)){
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
            else if (Greenfoot.isKeyDown(down)){
                setLocation(getX(), getY()+2);
            }
            if (!Greenfoot.isKeyDown(right) && !Greenfoot.isKeyDown(up) && !Greenfoot.isKeyDown(left) && !Greenfoot.isKeyDown(down)){
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
        if(numeroVidas >0){
            controlBala++;
            if (controlBala >20 && Greenfoot.isKeyDown(shoot)){
                getWorld().addObject(new Bala(this), getX(),getY()-5);
                controlBala = 0;
            }
        }
    }

}

