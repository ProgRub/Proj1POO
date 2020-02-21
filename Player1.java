import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    private String up = "w";
    private String left = "a";
    private String right = "d";
    private String down = "s";
    
    public Player1(){}
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move(){
        if (Greenfoot.isKeyDown(up)){
            setLocation(getX(), getY()-2);
        }
        else if (Greenfoot.isKeyDown(left)){
            setLocation(getX()-2, getY());
        }
        else if (Greenfoot.isKeyDown(right)){
            setLocation(getX()+2, getY());
        }
        else if (Greenfoot.isKeyDown(down)){
            setLocation(getX(), getY()+2);
        }
    }
}
