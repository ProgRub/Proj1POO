import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Esquimó1 extends Player1
{
    private GreenfootImage[] animacao=new GreenfootImage[6];
    private int contador;
    private int indice=0;
    
    public void act() 
    {
        animacao[0] = new GreenfootImage(cor+"");
    }  

    private void animarMove(){
        contador++;
        if (contador==4){
            if (numeroVidas >0){
                if(indice<6)
                {
                    indice++;
                }
                else
                {
                    indice=1;
                }
                setImage(animacao[indice]);
            }
            contador=0;
        }
    
       emCimaPlataforma();
    }    
    
    public void emCimaPlataforma(){
        if (isTouching(PlataformaGelo.class)){
            
        }
    }
}
