import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class myWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    private int scrollPosition = 0;
    int x;
    int started=0;
    private GreenfootImage bgImage, bgBase;
    private static final String bgImageName = "a.png";
    private static final String gameOver = "gameOver.png";
    GreenfootSound bgsound = new GreenfootSound("merida.wav");
    private static final double scrollSpeed = 2.5;
    iMeridaState MeridaAliveState, MeridaLostState, MeridaState;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    public GamePoints gp;
    public blueDiamond healthscore;
    private SimpleTimer timer = new SimpleTimer();
    public myWorld()
    {    
    super(1000, 600, 1); 
    prepare();
    }
    public void prepare()
    {
        setBackground(bgImageName);
        gp=new GamePoints();
     //added health
     healthscore=new blueDiamond();
     spawnSpikes();
        addObject(new GamePoints(), getWidth()-150, 70);
        addObject(new blueDiamond(), getWidth()-350, 70);
        buttonCancel ButtonCancel = new buttonCancel();
        buttonPlay ButtonPlay = new buttonPlay();
        addObject(ButtonPlay, 500, 500);
        addObject(ButtonCancel, 960, 60 );
        moreDiamonds();
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
    
    }
    public void act()
    {
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition);
        if(timeElapsed()){
           //timer.mark()-is set in brave class - begins after the play button is clicked.
           //code for setting the game over screen along with the end score goes here
            //setBackground(gameOver);
           //MeridaState.setState();
           Greenfoot.stop();
           
        }
    }
    public boolean timeElapsed()
    {
       //Checks if the game has exceeded the time limit of 1 minute
       if (timer.millisElapsed() > 15000)
        {
            //timer.mark();
            return true;           
             // Reset the timer
        } 
        else
        {
            return false;
        }
    }
    
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }

    public void moreDiamonds()
    {   
        greenFactory gf = new greenFactory();
        redFactory rf = new redFactory();
        yellowFactory yf = new yellowFactory();
        
        int rnum1 = Greenfoot.getRandomNumber(50);
        int rnum2 = Greenfoot.getRandomNumber(75);
        int rnum3 = Greenfoot.getRandomNumber(100);

        if(getObjects(Factory.class).size() < 10)
        {

            if (rnum1 ==0)

            {
                addObject( gf.makeDiamonds(), getWidth(), getHeight()-30);
                addObject( yf.makeDiamonds(), getWidth()-150, getHeight()-30);

            }

            else if(rnum1 == 1 )
            {
                addObject( yf.makeDiamonds(), getWidth(), getHeight()-30);

            }

            else if(rnum1 == 2)
            {

                addObject(rf.makeDiamonds(), getWidth(), getHeight()-30);
                
            }
            
             if (rnum2 ==0)

            {
                addObject( gf.makeDiamonds(), getWidth(), getHeight()-110);
                addObject( rf.makeDiamonds(), getWidth(), getHeight()-110);

            }

            else if(rnum2 == 1 )
            {
                addObject( gf.makeDiamonds(), getWidth(), getHeight()-110);

            }

            else if(rnum2 == 2)
            {

                addObject(yf.makeDiamonds(), getWidth(), getHeight()-110);
                
            }
            
             if (rnum3 ==0)

            {
                addObject( gf.makeDiamonds(), getWidth(), getHeight()-150);
                addObject( yf.makeDiamonds(), getWidth(), getHeight()-150);

            }

            else if(rnum3 == 1 )
            {
                addObject( gf.makeDiamonds(), getWidth(), getHeight()-150);

            }

            else if(rnum3 == 2)
            {

                addObject(yf.makeDiamonds(), getWidth(), getHeight()-150);
                
            }
           
        }
    }
    public void start()
    {
     //gp=new GamePoints();
     spawnSpikes();
     moreDiamonds();
     //System.out.println("IN SPasdasIKE");
     started=1;
     bgsound.playLoop();
     addObject(new spawner(),0,0);
     addObject(new Brave(),135,520);
    }
    public void spawnSpikes()
    {
        
       // addObject(new blockObstacle(),0,460);
        //System.out.println("IN SPIKE");
           if (started==1)
        {
            moreDiamonds();
            
        x=Greenfoot.getRandomNumber(8);
        if (x==0)
        {
       //spikeObstacle sp1=new spikeObstacle(new VerticalBehaviour());
       //addObject(sp1,500,565);
       //sp1.doChange(sp1);
            //addObject(new Obstacle(),970,515);
          //  addObject(new spike(), 900, 515);
            //addObject(new spike(), 700+Greenfoot.getRandomNumber(200), 303);
        }
        if (x==1)
        {
            //addObject(new spike(), 720, 513);
        //    addObject(new spike(), 700+Greenfoot.getRandomNumber(200), 503);
            //  addObject(new Obstacle(),600,400+Greenfoot.getRandomNumber(100));   
    }
        if (x==2)
        {       
            //addObject(new spike(), 900, 520);
            //addObject(new spike(), 862, 530);
           // addObject(new spike(), 620+Greenfoot.getRandomNumber(200), 503);
            addObject(new Obstacle(),900,475);
        
        }
        if (x==3)
        {
           // addObject(new blockObstacle(),580,415);
            //addObject(new blockObstacle(),150,425);
            addObject(new spike(), 800, 502);
            //addObject(new spike(), 902, 513);
            //addObject(new spike(), 794, 563);
          //addObject(new spike(), 750+Greenfoot.getRandomNumber(200), 303);
        }
    
    }}
}
