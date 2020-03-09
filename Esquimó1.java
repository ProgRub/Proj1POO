import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Esquimó1 extends Player1
{
    private GreenfootImage[] animacao;

    public Esquimó1()
    {      
        animacao=new GreenfootImage[5];
        for(int i=0; i <animacao.length;i++)
        {
            animacao[i]=new GreenfootImage(cor+"/Jogo3/"+(i+1)+".png");
        }
    }

    public void act() 
    {
        queda();
        move();
        salvarPinguim();
        cair(this, animacao);
    }
    
    /**
     * Método que trata do movimento do esquimó
     */
    protected void move()
    {
        if(numeroVidas > 0 &&!P2morreu){
            if (Greenfoot.isKeyDown(up) && podeSaltar){
                saltou=true;
                podeSaltar=false;
            }
            if(saltou){
                jump();
            }
            if (Greenfoot.isKeyDown(left)){
                if (!andandoParaEsquerda){
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()-3, getY());
                andandoParaEsquerda=true;
                animarMove(animacao);
            }
            else if (Greenfoot.isKeyDown(right) ){
                if (andandoParaEsquerda){
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()+3, getY());
                andandoParaEsquerda=false;
                animarMove(animacao);
            }
            if (!Greenfoot.isKeyDown(right) && !Greenfoot.isKeyDown(up) && !Greenfoot.isKeyDown(left)){
                indice=0;
                setImage(animacao[indice]);
            }
        }
    }

    /**
     * Método que trata da parte da subida do salto
     */
    protected void jump(){
        if (tempoJump>0){
            setLocation(getX(),getY()-tempoJump);
            tempoJump--;
        }
        else{
            tempoJump=GRAVIDADE;
            saltou=false;
        }
    }
    
    /**
     * Método que trata da parte da descida do salto, evita que os jogadores fiquem a meio do bloco e regista se chegou à plataforma final
     */
    protected void queda(){
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, PlataformaGelo.class);
        if (plat==null  && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }
        else if (plat!=null){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);
            tempoQueda=0;
            podeSaltar=true;
            if (plat instanceof Plataforma_Final)
            {
                Jogo3.setP1Chegou(true);
            }
        }
        plat=null;
    }   
    
    public static void setP2Morreu(boolean x)
    {
        P2morreu = x;
    }
    
    /**
     * Método que regista que o esquimó "salvou" o pinguim, dando-lhe 50 de pontuação
     */
    private void salvarPinguim()
    {
        if (isTouching(Pinguim.class))
        {
            Player1.adicionaScore(50);
            removeTouching(Pinguim.class);
        }
    }
}
