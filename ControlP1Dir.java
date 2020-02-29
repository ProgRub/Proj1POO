import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlP1Dir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlP1Dir extends Options
{
    private Boolean flag = true;
    private Boolean prepara=true;
    private static Actor text = new Texto();
    public void act() 
    {
        if (prepara){
            getWorld().addObject(text, getX(), getY());
            updateText(Player1.getControls()[2],text,40, new Color(255,255,255));
            prepara=false;
        }
        getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        moveMouseBotaoControlos();
        clickMouse();
    }    

    public void clickMouse(){
        if (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(text)){
            Greenfoot.getKey();
            updateText("Press any key",text,30, new Color(255,255,255));
            Greenfoot.delay(1);
            while (flag){
                String key= Greenfoot.getKey();
                if (key!=null && Players.podeMudar(Player1.getControls(),Player2.getControls(),key)){
                    Player1.setControls(2,key);
                    flag=false;
                    if(!flag){
                        updateText(Player1.getControls()[2],text,40, new Color(255,255,255));
                    }
                }
            }
            flag=true;
        }
    }    
}
