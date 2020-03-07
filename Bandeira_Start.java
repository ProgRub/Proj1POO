import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandeira_Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    private void permanecerParado()
    {
        if (contador >650)
        {
            move(-1);
        }
        contador++;
        
    }
    
    private void desaparecer(){
        if (getX() == 0){
            getWorld().removeObject(this);
        }
    }
}