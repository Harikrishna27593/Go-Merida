import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objects extends Actor
{
    public int x;
    public static int bluescore;
    blueDiamond b=new blueDiamond();
    /**
     * Act - do whatever the Objects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void moving()
    {
        move(-2);
    }
    
    public void despawning()
    {
        x=getX();
        
        if (x==0)
        {
            getWorld().removeObject(this);
        }
        else if(isTouching(Brave.class))
        {
            getWorld().removeObject(this);
            bluescore++;    
            b.update(bluescore);
        }
    }
}
