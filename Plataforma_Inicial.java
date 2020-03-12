import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plataforma_Inicial extends PlataformaGelo
{
    private int contador;
    private GreenfootImage imagemAtual;
    
    public Plataforma_Inicial()
    {
        imagemAtual = new GreenfootImage("platf1.png");
        //A largura das plataformas será tanto maior quanto menor foi o dano à camada de ozono no jogo 2
        imagemAtual.scale(imagemAtual.getWidth()-(125-CamadaOzono.getVida())/5, imagemAtual.getHeight());
        setImage(imagemAtual);
        contador =0;
    }
    
    public void act() 
    {
        desaparecer();
        permanecerParado();
    } 
    
    public void permanecerParado()
    {
        if (contador >650)
        {
            move(-1);
        }
        contador++;
        
    }
}
