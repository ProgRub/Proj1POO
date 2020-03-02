import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlataformaGelo extends Jogos
{
    private boolean pinguim;
    private int comprimentoMundo;
    private GreenfootImage imagemAtual;
    public PlataformaGelo(){
        podeCriarPinguim();
        imagemAtual = new GreenfootImage("platf1.png");
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
        
        if (getX() == 960){
            imagemAtual.setTransparency(240);
        }else if (getX() == 720){
            imagemAtual.setTransparency(200);
        }else if (getX() == 480){
            imagemAtual.setTransparency(150);
        }else if (getX() == 240){
            imagemAtual.setTransparency(110);
        }else if (getX() == 30){
            imagemAtual.setTransparency(70);
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
            getWorld().addObject(new Pinguim(), getX() + Greenfoot.getRandomNumber(50)-50, getY()-getImage().getHeight());
            pinguim = false;
        }
    }
    public void desaparecer(){
        if (getX() == 0){
            getWorld().removeObject(this);
        }
    }
}
