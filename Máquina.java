import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Máquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Máquina extends Jogos
{           
    private static int vida=2;
    private static int contador;
    private GreenfootImage explosao[] = new GreenfootImage[13];
    private int indice=0;

    private GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13;
    public Máquina(){
        vida=2;
        explosao[0] = new GreenfootImage("ExplosionMáquina/1.png");
        explosao[1] = new GreenfootImage("ExplosionMáquina/2.png");
        explosao[2] = new GreenfootImage("ExplosionMáquina/3.png");
        explosao[3] = new GreenfootImage("ExplosionMáquina/4.png");
        explosao[4] = new GreenfootImage("ExplosionMáquina/5.png");
        explosao[5] = new GreenfootImage("ExplosionMáquina/6.png");
        explosao[6] = new GreenfootImage("ExplosionMáquina/7.png");
        explosao[7] = new GreenfootImage("ExplosionMáquina/8.png");
        explosao[8] = new GreenfootImage("ExplosionMáquina/9.png");
        explosao[9] = new GreenfootImage("ExplosionMáquina/10.png");
        explosao[10]= new GreenfootImage("ExplosionMáquina/11.png");
        explosao[11] = new GreenfootImage("ExplosionMáquina/12.png");
        explosao[12] = new GreenfootImage("ExplosionMáquina/13.png");
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
