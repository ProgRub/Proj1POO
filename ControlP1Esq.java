import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlP1Esq here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlP1Esq extends Options
{
    private static GreenfootImage botao =new GreenfootImage(100,50);
    private Boolean flag = true;
    public void act() 
    {
        // Add your action code here.
        clickMouse();
        botao.setColor(Color.DARK_GRAY);
        botao.fill();
        setImage(botao);
    }    

    public void clickMouse(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.getKey();
            while (flag){
                String key= Greenfoot.getKey();
                if (key!=null){
                    Player1.left=key;
                    flag=false;
                }
            }
            System.out.println(Player1.left);
        }
    }    
}