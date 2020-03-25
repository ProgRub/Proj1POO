import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Máquina extends Jogos
{           
    private static int vida;
    private static int contador;
    private GreenfootImage[] explosao;
    private int indice;

    public Máquina(){
        vida=500;
        explosao = new GreenfootImage[13];
        for (int i=0; i< explosao.length; i++)
        {
            explosao[i] = new GreenfootImage("ExplosionMáquina/"+(i+1)+".png");
        }
        contador=0;
        indice=0;
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
            getWorld().addObject(new Gas(),this.getX()+Greenfoot.getRandomNumber(40)-10, this.getY() - this.getImage().getHeight()/2);
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
                Greenfoot.playSound("explosion.mp3");
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