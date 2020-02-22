import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Players
{
    private String up = "up";
    private String left = "left";
    private String right = "right";
    private String down = "down";


    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
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
