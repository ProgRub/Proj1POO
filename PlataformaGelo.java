import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlataformaGelo extends Jogos
{
    private boolean pinguim;
    private GreenfootImage imagemAtual;
    public PlataformaGelo(int subtrair){
        podeCriarPinguim();
        imagemAtual = new GreenfootImage("platf1.png");
        //A largura das plataformas será tanto maior quanto menor foi o dano à camada de ozono no jogo 2
        imagemAtual.scale(imagemAtual.getWidth()-(125-CamadaOzono.getVida())/5+subtrair, imagemAtual.getHeight());
        setImage(imagemAtual);
    }
    
    public PlataformaGelo(){
    }

    public void act() 
    {
        move(-1);
        derreter();
        desaparecer();
        invocaPinguim();
    }    
    
    /**
     * Método para simular que as plataformas de Gelo estão a derreter, para alterar a tranparência do objeto quando estiver quase alcançando o
     * limite esquerdo do mundo, e fazer com que a plataforma pareça que está a cair quando aproxima o limite esquerdo do mundo
     */
    public void derreter(){
        if (Greenfoot.getRandomNumber(100)<=1){
            getWorld().addObject(new Gota(), getX() + Greenfoot.getRandomNumber(50)-50, getY());
        }
        if(getX()%75==0)
        {
            imagemAtual.setTransparency(imagemAtual.getTransparency()-10);
        }
        else if(getX()<40)
        {
            imagemAtual.setTransparency(70);
            turn(-2);
            setLocation(getX(), getY()+8);
        }
        setImage(imagemAtual);
    }

    
    public void podeCriarPinguim(){
        if (Greenfoot.getRandomNumber(100)<=20){
            pinguim=true;
        }else{
            pinguim=false;
        }
    }

    /**
     * Método para adicionar objetos da classe "Pinguim" em cima das plataformas
     */
    public void invocaPinguim(){
        if (pinguim == true){
            Pinguim peng = new Pinguim();
            getWorld().addObject(peng, getX() - Greenfoot.getRandomNumber(getImage().getWidth()/2), getY()-getImage().getHeight()/2 - peng.getImage().getHeight()/2);
            pinguim = false;
            peng=null;
        }
    }

    public void desaparecer(){
        if (getX() == 0 || getY() == getWorld().getHeight()-1){
            GreenfootSound som = new GreenfootSound("splash.mp3");
            som.play();
            som.setVolume(30);
            getWorld().removeObject(this);
        }
    }
}
