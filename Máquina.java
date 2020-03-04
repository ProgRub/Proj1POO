import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Máquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Máquina extends Jogos
{           
    private static int vida=500;
    private static int score;
    private static int contador;
    private GreenfootImage explosao[] = new GreenfootImage[13];
    private int indice=0;

    private GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13;
    public Máquina(){
        vida=500;
        score=0;
        explosion1 = new GreenfootImage("ExplosionMáquina/1.png");
        explosion2 = new GreenfootImage("ExplosionMáquina/2.png");
        explosion3 = new GreenfootImage("ExplosionMáquina/3.png");
        explosion4 = new GreenfootImage("ExplosionMáquina/4.png");
        explosion5 = new GreenfootImage("ExplosionMáquina/5.png");
        explosion6 = new GreenfootImage("ExplosionMáquina/6.png");
        explosion7 = new GreenfootImage("ExplosionMáquina/7.png");
        explosion8 = new GreenfootImage("ExplosionMáquina/8.png");
        explosion9 = new GreenfootImage("ExplosionMáquina/9.png");
        explosion10 = new GreenfootImage("ExplosionMáquina/10.png");
        explosion11= new GreenfootImage("ExplosionMáquina/11.png");
        explosion12 = new GreenfootImage("ExplosionMáquina/12.png");
        explosion13 = new GreenfootImage("ExplosionMáquina/13.png");
        contador=0;
    }

    public void act() 
    {
        libertaGas();
        maquinaDestruida();
    }   

    public static int getVida()
    {
        return vida;
    }   

    public static void tiraVida(int valor)
    {
        vida-=valor;
    }

    private void libertaGas(){
        if (Greenfoot.getRandomNumber(100)>97 && vida > 0){
            Máquina maq = getWorld().getObjects(Máquina.class).get(0);
            getWorld().addObject(new Gas(),maq.getX()+Greenfoot.getRandomNumber(40)-10, maq.getY() - maq.getImage().getHeight()/2);
        }
    }

    private void maquinaDestruida(){
        if (vida <= 0 && contador%3==0){
            Jogo1.getSomChuva().stop();
            if(indice==0)
            {
                Greenfoot.playSound("explosion.wav");
            }
            setImage(explosao[indice]);
            indice++;
            if(indice>=explosao.length)
            {
                Greenfoot.setWorld(new Stage1Complete());
                getWorld().removeObject(this);
            }
        }
        contador++;
    }

}
