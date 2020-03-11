import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controlos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlos extends Options
{
    private Boolean flag;
    private Boolean prepara;
    private int player;
    private int controlo;
    private Texto text;
    private GreenfootImage image1, image2;
    public Controlos (int player, int controlo)
    {
        this.flag = true;
        this.prepara=true;
        this.player=player;
        this.controlo=controlo;
        this.text = new Texto();
        this.image1 = new GreenfootImage("BotaoControlos.png");
        this.image2 = new GreenfootImage("BotaoControlos2.png");
        setImage(image1);
    }

    public void act() 
    {
        if (prepara){
            getWorld().addObject(text, getX(), getY());
            if (player == 1)
            {
                text.updateText(Player1.getControls()[controlo],text,40, new Color(255,255,255));
            }
            else
            {
                text.updateText(Player2.getControls()[controlo],text,40, new Color(255,255,255));
            }
            prepara=false;
            image1.scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
            image2.scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        }
        moveMouse(image2,image1);
        clickMouse(player,controlo);
    }    

    /**
     * Método que regista que o utilizador clicou no botão para mudar o controlo escolhido e espera que o mesmo dê uma tecla válida,
     * não pode escolher uma tecla que esteja ocupada para outro controlo, quer do player 1 quer do player 2
     */
    public void clickMouse(int player, int controlo){
        if (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(text)){
            playClick();
            Greenfoot.getKey();
            text.updateText("Press any key",text,30, new Color(255,255,255));
            Greenfoot.delay(1);
            while (flag){
                String key= Greenfoot.getKey();
                if (key!=null && Players.podeMudar(Player1.getControls(),Player2.getControls(),key)){
                    if (player == 1)
                    {
                        Player1.setControls(controlo,key);
                    }
                    else
                    {
                        Player2.setControls(controlo,key);
                    }

                    flag=false;
                    if(!flag){
                        if (player == 1)
                        {
                            text.updateText(Player1.getControls()[controlo],text,40, new Color(255,255,255));
                        }
                        else
                        {
                            text.updateText(Player2.getControls()[controlo],text,40, new Color(255,255,255));
                        }
                    }
                }
            }
            flag=true;
        }
    }
}
