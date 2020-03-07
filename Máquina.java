import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Máquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Máquina extends Jogos
{           
    private static int vida;
    private static int score;
    private static int contador;
    private GreenfootImage explosao[] = new GreenfootImage[13];
    private int indice=0;

    private GreenfootImage explosion1,explosion2,explosion3,explosion4,explosion5,explosion6,explosion7,explosion8,explosion9,explosion10,explosion11,explosion12,explosion13;
    public Máquina(){
        vida=2;
        score=0;
        for (int i=0; i< explosao.length; i++)
        {
            explosao[i] = new GreenfootImage("ExplosionMáquina/"+(i+1)+".png");
        }
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
    
    /**
     * Método que invoca objetos da classe Gas, de modo a mostrar que a máquina está a poluir a atmosfera
     */
    private void libertaGas(){
        if (Greenfoot.getRandomNumber(100)>97 && vida > 0){
            Máquina maq = getWorld().getObjects(Máquina.class).get(0);
            getWorld().addObject(new Gas(),maq.getX()+Greenfoot.getRandomNumber(40)-10, maq.getY() - maq.getImage().getHeight()/2);
        }
    }
    
    /**
     * Método que anima a explosão que acontece quando a máquina é destruída, toca o som da explosão e avança o mundo para mostrar o score
     */
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
