import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    public static String up = "w";
    public static String left = "a";
    public static String right = "d";
    public static String down = "s";
    public static String shoot ="f";
    private GreenfootImage image1,image2,image3,image4,image5,image6;
    private int contador=0;
    public static boolean andandoParaEsquerda;
    private Bala bullet;
    private int controlBala=0;
    public Player1(){
        image1 = new GreenfootImage("Green/1.png");
        image2 = new GreenfootImage("Green/2.png");
        image3 = new GreenfootImage("Green/3.png");
        image4 = new GreenfootImage("Green/4.png");
        image5 = new GreenfootImage("Green/5.png");
        image6 = new GreenfootImage("Green/6.png");
        setImage(image1);
        andandoParaEsquerda = false;
    }

    public void act() 
    {
        move();
        disparar();

    }    

    public void move(){
        if (Greenfoot.isKeyDown(up)){
            jump();
        }
        else if (Greenfoot.isKeyDown(left)){
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

    public void jump(){
        for (int i=10;i>0;i--){            
            setLocation(getX(),getY()-1);
        }
    }

    public void animarMove(){
        contador++;
        if (contador==4){
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
            contador=0;
        }
    }

    public void disparar(){
        controlBala++;
        if (controlBala >20){
            if (Greenfoot.isKeyDown(shoot)){
                bullet = new Bala();
                getWorld().addObject(bullet, getX(),getY()-5);
                controlBala = 0;
            }
        }
    }
}
