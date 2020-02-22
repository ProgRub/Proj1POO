import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlP2Baixo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlP2Baixo extends Options
{
    private Boolean flag = true;
    public void act() 
    {
        getImage().scale((int)(1.5*getWorld().getWidth()/9), getWorld().getHeight()/9);
        moveMouseBotaoControlos();
        clickMouse();
    }    

    public void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.getKey();
            while (flag){
                String key= Greenfoot.getKey();
                if (key!=null){
                    Player2.down=key;
                    flag=false;
                }
            }
            System.out.println(Player2.down);
        }
    }    
}
