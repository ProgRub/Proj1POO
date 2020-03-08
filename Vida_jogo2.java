import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Vida_jogo2 extends Vida
{
    public void act() 
    {
        movimentoVida();
        ultrapassaLimite();
    } 
    
    /**
     * "Overriding" do método movimentoVida() herdado da classe "Vida"
     * Método que define o movimento (ascendente) da vida, para o jogo 2
     */
    public void movimentoVida() 
    {
        setLocation(getX(), getY() - 3);
    }   
    
    
    /**
     * "Overriding" do método ultrapassaLimite() herdado da classe "ObjetosCaem"
     * Método que remove o objeto quando toca nos limites do mundo, pois este objeto não tocará num objeto do tipo "Chão" mas tocará
     * sim nos limites do mundo
     */
    protected void ultrapassaLimite()
    {
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
