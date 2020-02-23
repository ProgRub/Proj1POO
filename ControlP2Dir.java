import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlP2Dir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlP2Dir extends Options
{
    private Boolean flag = true;
    private Boolean prepara=true;
    private static Actor text = new Texto();
    public void act() 
    {
        if (prepara){
            getWorld().addObject(text, getX(), getY());
            updateText(Player2.getRight(),text);
            prepara=false;
        }
        getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        moveMouseBotaoControlos();
        clickMouse();
    }    

    public void clickMouse(){
        if (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(text)){
            Greenfoot.getKey();
            updateText("Press any key", text);
            Greenfoot.delay(1);
            while (flag){
                String key= Greenfoot.getKey();
                if (key!=null){
                    Player2.setRight(key);
                    flag=false;
                    if(!flag){
                        updateText(Player2.getRight(),text);
                    }
                }
            }
            flag=true;
        }
    }    
}
