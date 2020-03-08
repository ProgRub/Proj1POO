import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HowToPlay extends World
{
    private Texto info;
    private static int jogo;
    public HowToPlay()
    {   
        super(1200, 700, 1);
        GreenfootImage bg = new GreenfootImage("Earth.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare();
    }

    /**
     *  Métodos que permitem determinar qual explicação mostrar aos jogadores dependendo do jogo que vão jogar
     */
    
    public static void mudarJogo(int aux){
        jogo = aux;
    }

    public static int jogoAtual(){
        return jogo;
    }
    
    public void prepare(){
        switch (jogo)
        {
            case 1:
            info = new Texto("𝐈𝐧 𝐭𝐡𝐢𝐬 𝐬𝐭𝐚𝐠𝐞, 𝐲𝐨𝐮𝐫 𝐭𝐚𝐬𝐤 𝐢𝐬 𝐭𝐨 𝐝𝐞𝐬𝐭𝐫𝐨𝐲 𝐭𝐡𝐞 𝐦𝐚𝐜𝐡𝐢𝐧𝐞 \n𝐭𝐡𝐚𝐭 𝐢𝐬 𝐩𝐨𝐥𝐥𝐮𝐭𝐢𝐧𝐠 𝐭𝐡𝐞 𝐚𝐭𝐦𝐨𝐬𝐩𝐡𝐞𝐫𝐞, 𝐛𝐮𝐭 𝐛𝐞 𝐜𝐚𝐫𝐞𝐟𝐮𝐥! \n𝐃𝐨𝐝𝐠𝐞 𝐭𝐡𝐞 𝐟𝐚𝐥𝐥𝐢𝐧𝐠 𝐡𝐚𝐢𝐥 𝐚𝐧𝐝 𝐥𝐢𝐠𝐡𝐭𝐧𝐢𝐧𝐠 𝐨𝐫 𝐭𝐡𝐞 𝐠𝐚𝐦𝐞 𝐰𝐢𝐥𝐥 𝐛𝐞 𝐨𝐯𝐞𝐫!",45, new Color(222, 18, 195));
            break;
            case 2:
            info = new Texto("𝐍𝐨𝐰 𝐭𝐡𝐚𝐭 𝐲𝐨𝐮 𝐡𝐚𝐯𝐞 𝐬𝐮𝐫𝐯𝐢𝐯𝐞𝐝 𝐭𝐡𝐨𝐬𝐞 𝐡𝐚𝐫𝐬𝐡 𝐜𝐨𝐧𝐝𝐢𝐭𝐢𝐨𝐧𝐬, 𝐜𝐥𝐢𝐦𝐛 𝐚𝐛𝐨𝐚𝐫𝐝\n𝐲𝐨𝐮𝐫 𝐬𝐩𝐚𝐜𝐞𝐬𝐡𝐢𝐩𝐬 𝐚𝐧𝐝 𝐩𝐫𝐞𝐯𝐞𝐧𝐭 𝐭𝐡𝐞 𝐭𝐨𝐱𝐢𝐜 𝐠𝐚𝐬𝐞𝐬 𝐭𝐡𝐚𝐭 𝐦𝐚𝐜𝐡𝐢𝐧𝐞 𝐫𝐞𝐥𝐞𝐚𝐬𝐞𝐝 \n𝐟𝐫𝐨𝐦 𝐜𝐨𝐦𝐩𝐥𝐞𝐭𝐞𝐥𝐲 𝐝𝐞𝐬𝐭𝐫𝐨𝐲𝐢𝐧𝐠 𝐭𝐡𝐞 𝐨𝐳𝐨𝐧𝐞 𝐥𝐚𝐲𝐞𝐫! 𝐁𝐮𝐭 𝐢𝐭 𝐰𝐨𝐧'𝐭 𝐛𝐞 𝐭𝐡𝐚𝐭 \n𝐞𝐚𝐬𝐲, 𝐲𝐨𝐮'𝐥𝐥 𝐡𝐚𝐯𝐞 𝐭𝐨 𝐝𝐨𝐝𝐠𝐞 𝐭𝐡𝐞 𝐠𝐮𝐢𝐝𝐞𝐝 𝐦𝐢𝐬𝐬𝐢𝐥𝐞𝐬 𝐛𝐞𝐢𝐧𝐠 𝐟𝐢𝐫𝐞𝐝 𝐚𝐭 𝐲𝐨𝐮!",45, new Color(222, 18, 195));
            break;
            case 3:
            info = new Texto("𝐅𝐨𝐫 𝐭𝐡𝐢𝐬 𝐟𝐢𝐧𝐚𝐥 𝐬𝐭𝐚𝐠𝐞 𝐚𝐥𝐥 𝐲𝐨𝐮 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐝𝐨 𝐢𝐬 𝐧𝐚𝐯𝐢𝐠𝐚𝐭𝐞 𝐭𝐡𝐫𝐨𝐮𝐠𝐡 𝐭𝐡𝐞 𝐢𝐜𝐞 \n𝐩𝐥𝐚𝐭𝐟𝐨𝐫𝐦𝐬 𝐟𝐫𝐨𝐦 𝐬𝐭𝐚𝐫𝐭 𝐭𝐨 𝐟𝐢𝐧𝐢𝐬𝐡 𝐚𝐧𝐝 𝐬𝐚𝐯𝐞 𝐭𝐡𝐞 𝐩𝐞𝐧𝐠𝐮𝐢𝐧𝐬 𝐟𝐨𝐫 \n𝐛𝐨𝐧𝐮𝐬 𝐬𝐜𝐨𝐫𝐞, 𝐛𝐮𝐭 𝐛𝐞 𝐜𝐚𝐫𝐞𝐟𝐮𝐥 𝐛𝐞𝐜𝐚𝐮𝐬𝐞 \n𝐨𝐧𝐞 𝐰𝐫𝐨𝐧𝐠 𝐦𝐨𝐯𝐞 𝐚𝐧𝐝 𝐚𝐥𝐥 𝐭𝐡𝐞 𝐰𝐨𝐫𝐤 𝐰𝐢𝐥𝐥 𝐠𝐨 𝐭𝐨 𝐰𝐚𝐬𝐭𝐞!",45, new Color(222, 18, 195));
            break;
        }
            addObject(info, getWidth()/2, getHeight()/2);
            Start startGame = new Start();
            addObject(startGame, getWidth()/2,516);

        }
    }
