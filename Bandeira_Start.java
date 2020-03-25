import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bandeira_Start extends Jogos
{
    private int contador;
    public Bandeira_Start()
    {
        contador =0;
        GreenfootImage imagemAtual=getImage();
        imagemAtual.scale(imagemAtual.getWidth()-(125-CamadaOzono.getVida())/5, imagemAtual.getHeight()); 
    }
    
    public void act() 
    {
        desaparecer();
        permanecerParado();
    }     

    /**
     * Método que move a bandeira de acordo com o movimento da plataforma inicial, onde a bandeira está
     */
    public void permanecerParado()

    {
        if (contador >650)
        {
            move(-1);
        }
        contador++;        
    }
    
    /**
     * Método que faz com que a bandeira desapareça do mundo, assim que esta toque no limite esquerdo do mundo (X=0)
     */
    public void desaparecer() 
        { 
        if (getX() == 0){
            getWorld().removeObject(this);
        }
    }
}