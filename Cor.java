import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cor extends Menus
{
    private static boolean P1escolheu;
    private String cor;

    public Cor(int valor)
    {
        GreenfootImage image = new GreenfootImage(125,125);
        switch (valor)
        {
            case 0:
            image.setColor(new Color(149,19,23)); //Vermelho
            cor = "Red";
            break;
            case 1:
            image.setColor(new Color(55,55,57)); //Preto
            cor = "Black";
            break;
            case 2:
            image.setColor(new Color(54,182,73)); //Verde
            cor = "Green";
            break;
            case 3:
            image.setColor(new Color(245,239,44)); //Amarelo
            cor = "Yellow";
            break;
            case 4:
            image.setColor(new Color(6,118,189)); //Azul
            cor = "Blue";
            break;
        }
        image.fillOval(0, 0, 125, 125);
        this.setImage(image);
        P1escolheu=false;
    }
    
    public void act() 
    {
        clickMouse();
    }
    
    /**
     * Método que regista a cor que os jogadores escolheram e atualiza as variáveis e o mundo de acordo
     */
    private void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            playClick();
            if(!P1escolheu){
                Player1.setColor(cor);
                P1escolheu = true;
                Texto.updateText(Player2.getNome()+",\npick your colour", getWorld().getObjects(Texto.class).get(0), 60, new Color(255,255,255));
                getWorld().removeObject(this);
            }
            else{
                Player2.setColor(cor);
                Greenfoot.setWorld(new HowToPlay());
            }
        }
    } 
}
