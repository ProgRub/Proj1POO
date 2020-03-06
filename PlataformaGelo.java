import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlataformaGelo extends Jogos
{
    private boolean pinguim;
    private int comprimentoMundo;
    private GreenfootImage imagemAtual;
    public PlataformaGelo(){
        podeCriarPinguim();
        imagemAtual = new GreenfootImage("platf1.png");
        System.out.println(250-CamadaOzono.getVida());
        imagemAtual.scale(imagemAtual.getWidth()-(250-CamadaOzono.getVida())/5, imagemAtual.getHeight());
        setImage(imagemAtual);
    }

    public void act() 
    {
        move(-1);
        derreter();
        desaparecer();
        invocaPinguim();
    }    

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

    public void invocaPinguim(){
        if (pinguim == true){
            Pinguim peng = new Pinguim();
            getWorld().addObject(peng, getX() + Greenfoot.getRandomNumber(50)-50, getY()-getImage().getHeight()/2 - peng.getImage().getHeight()/2);
            pinguim = false;
            peng=null;
        }
    }

    public void desaparecer(){
        if (getX() == 0 || getY() == getWorld().getHeight()-1){
            Greenfoot.playSound("splash.mp3");
            getWorld().removeObject(this);
        }
    }
}
