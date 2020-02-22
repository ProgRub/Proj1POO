import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VidaMáquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VidaMáquina extends Máquina
{
    GreenfootImage cem,noventa,oitenta,setenta,sessenta,cinquenta,quarenta,trinta,vinte,dez;
    
    public VidaMáquina(){
        cem = new GreenfootImage("vidaaa.png");
        noventa = new GreenfootImage("90%.png");
        oitenta = new GreenfootImage("80%.png");
        setenta = new GreenfootImage("70%.png");
        sessenta = new GreenfootImage("60%.png");
        cinquenta = new GreenfootImage("50%.png");
        quarenta = new GreenfootImage("40%.png");
        trinta = new GreenfootImage("30%.png");
        vinte = new GreenfootImage("20%.png");
        dez = new GreenfootImage("10%.png");
        setImage(cem);
    }
    
    public void act() 
    {
       vidaAtual();
    }  
    
    public void vidaAtual(){
        if (Máquina.vida == 100){
            setImage(cem);
        }else if (Máquina.vida == 90){
            setImage(noventa);
        }
        else if (Máquina.vida == 80){
            setImage(oitenta);
        }
        else if (Máquina.vida == 70){
            setImage(setenta);
        }
        else if (Máquina.vida == 60){
            setImage(sessenta);
        }
        else if (Máquina.vida == 50){
            setImage(cinquenta);
        }
        else if (Máquina.vida == 40){
            setImage(quarenta);
        }
        else if (Máquina.vida == 30){
            setImage(trinta);
        }
        else if (Máquina.vida == 20){
            setImage(vinte);
        }
        else if (Máquina.vida == 10){
            setImage(dez);
        }
        else if (Máquina.vida == 0){
            getWorld().removeObject(this);
        }
    }
}
