import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EscolherCor extends World
{

    /**
     * Constructor for objects of class EscolherJogo.
     * 
     */
    public EscolherCor()
    {    
        super(1200, 700, 1); 
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare(); 
        HowToPlay.mudarJogo(1);
    }
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int larg=getWidth();
        int alt=getHeight();
        addObject(new Vermelho(),larg/6,2*alt/3);
        addObject(new Preto(),2*larg/6,2*alt/3);
        addObject(new Verde(),3*larg/6,2*alt/3);
        addObject(new Amarelo(),4*larg/6,2*alt/3); 
        addObject(new Azul(),5*larg/6,2*alt/3);       
        Cor.setP1escolheu(false);
        Texto text =new Texto(Player1.getNome()+",\npick your colour",60, new Color(255,255,255));
        addObject(text,larg/2,alt/3);
        addObject(new Back(), larg-100, alt-50);
    }
}
