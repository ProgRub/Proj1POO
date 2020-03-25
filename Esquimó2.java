import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Esquimó2 extends Player2
{
    private GreenfootImage[] animacao;
    
    public Esquimó2()
    {      
        animacao=new GreenfootImage[5];
        for(int i=0; i <animacao.length;i++)
        {
            animacao[i]=new GreenfootImage(getColor()+"/Jogo3/"+(i+1)+".png");
        }
    }

    public void act() 
    {
        queda();
        move();
        cair(this, animacao);
    }
    
    /**
     * Método que trata do movimento do esquimó
     */
    protected void move()
    {
        if(getNumeroVidas() > 0 && !getP1Morreu()){
            if (Greenfoot.isKeyDown(up) && podeSaltar){//certifica que so pode saltar se estiver na plataforma de gelo
                saltou=true;
                podeSaltar=false;
            }
            if(saltou){
                jump();
            }
            if (Greenfoot.isKeyDown(left)){
                if (!andandoParaEsquerda){//reflete as imagens,se necessário
                    for (int i=0; i < animacao.length;i++)
                    {
                        animacao[i].mirrorHorizontally();
                    }
                }
                setLocation(getX()-3, getY());
                andandoParaEsquerda=true;
                animarMove(animacao);
            }
            else if (Greenfoot.isKeyDown(right)){
                if (andandoParaEsquerda){//reflete as imagens,se necessário
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
        Actor plat = getOneObjectAtOffset(0,tempoQueda+getImage().getHeight()/2, PlataformaGelo.class); //verifica se, após a queda, o jogador estara em cima ou "dentro" da plataforma
        if (plat==null   && !saltou){
            setLocation(getX(),getY()+tempoQueda);
            tempoQueda++;
        }
        else if (plat!=null ){
            setLocation(getX(),plat.getY()- plat.getImage().getHeight()/2-getImage().getHeight()/2);//mete os jogadores mesmo em cima da plataforma
            tempoQueda=0;
            podeSaltar=true;
            if (plat instanceof Plataforma_Final)
            {
                Jogo3.setP2Chegou(true);
            }
        }
        plat=null;
    }
}