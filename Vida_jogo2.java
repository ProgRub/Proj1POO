import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida_jogo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida_jogo2 extends Vida
{
    /**
     * Act - do whatever the Vida_jogo2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimentoVida(); // para o jogo 2
        ultrapassaLimite();
    } 
    
    /**
     * "Overriding" do método movimentoVida() herdado da classe "Vida"
     * Método que define o movimento (ascendente) da vida
     */
    public void movimentoVida() 
    {
        setLocation(getX(), getY() - 3);
    }   
    
    
    /**
     * "Overriding" do método ultrapassaLimite() herdado da classe "ObjetosCaem"
     * Método que remove o objeto quando toca nos limites do mundo
     */
    protected void ultrapassaLimite()
    {
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
