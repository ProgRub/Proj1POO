import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlP1Cima here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlP1Cima extends Options
{
    private Boolean flag = true;
    private Boolean prepara=true;
    private static Actor text = new Texto();
    public void act() 
    {
        if (prepara){
            getWorld().addObject(text, getX(), getY());
            updateText(Player1.getUp(), text);
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
                    Player1.setUp(key);
                    flag=false;
                    if(!flag){
                        updateText(Player1.getUp(), text);
                    }
                }
            }
            flag=true;
        }
    }
}
