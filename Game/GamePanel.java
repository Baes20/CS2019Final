package CS2019Final;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {
	
	public static int WIDTH = 2500;
	public static int HEIGHT = 1200;
	
	private Thread thread;
	private boolean running;
	private BufferedImage image;
	private Graphics2D g;
	private int fps = 60;
	private int squareX = 50;
    private int squareY= 120;
    private int squareW = 100;
    private int squareH = 100;
    private ArrayList<Point> points;

    public static final Color BROWN = new Color(153,102,0);
    
    

	Battlefield B = new Battlefield(6, 20);

	
	//----------------------------------------------------------//
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		addMouseMotionListener(this);
		addMouseListener(this);
		
	}
	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void run() {
		running = true;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//fps
		long startTime;
		long URDTimeMillis;
		long waitTime;
		long targetTime = 1000 / fps;
		
		
		
		
		//-------------------- GAME LOOP -----------------//

	    addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	            int i = (int)((e.getY() - squareY)/100.0);
				int j = (int)((e.getX() - squareX)/100.0);
				B.getB()[i][j] = new DefaultPlant();
				System.out.println(i+" "+j);
	            //repaint();
	        }
	        
	        public void mouseDragged(MouseEvent e) {
	        	
	        }
	    });
	    
//	   while() {
//		   gameRender();
//		   for(Point point: points) {
//			   int i = (int)((point.y - squareY)/100.0);
//			   int j = (int)((point.x - squareX)/100.0);
//			   //if(B.getB()[i][j] instanceof NullNode) {
//				   B.getB()[i][j] = new DefaultPlant();
//			   //}
//		   }
//	   }
	   
	   
	   
	  
	    B.putPieces(new DefaultZombie(), 3, 13);
		B.putPieces(new DefaultZombie(), 4, 13);
		B.putPieces(new DefaultZombie(), 5, 15);
		B.putPieces(new DefaultZombie(), 1, 13);
		B.putPieces(new DefaultZombie(), 0, 12);
		B.putPieces(new DefaultZombie(), 3, 12);
	   
		long framecount = 0;
		while (running) {
			startTime = System.nanoTime();
			gameRender();
			if(framecount%60 == 0) {
				B.calcNextState();    	
			}
			gameDraw();
			
			
//			while(B.getPlayerHealth()>=0)
//			{
//			int random = (int)Math. random() * 5;	
//			B.putPieces(new DefaultZombie(), random, random);
//			B.putPieces(new DefaultZombie(), random, random);
//			B.putPieces(new DefaultZombie(), random, random);
//			}
			
		
			
			
			//fps
			URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - URDTimeMillis;
			try {
				Thread.sleep(waitTime);
			}
			catch (Exception e) {}
			running = !B.isGameOver();
			framecount++;
		}
		
	}
	
	public void paintComponent(Graphics g2) {
		
		        super.paintComponent(g2);
		Graphics2D g = (Graphics2D) g2;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        for (Point point : points) {
//        	int x = point.x;
//        	int y = point.y;
//        	int fixx =((x+25)/100)*100-20;
//        	int fixy = ((y+25)/100)*100-20 ;
//
//        	 ImageIcon image;                
//        	 image=new ImageIcon(getClass().getResource("/plant.png"));
//              g.drawImage(image.getImage(),fixx, fixy,null); 
//              
//        }
        
    }
	
	public void visualize() {
		
		
		
		for  (int i = 0; i<B.width; i++)
		{
			for (int j = 0; j<B.height; j++)
			{
				
				if(B.getB()[i][j] instanceof Zombie)
				{
					int fixx =(i*squareW)+75;
		        	int fixy = (j*squareH)+65 ;
			    ImageIcon image;                
			    image=new ImageIcon(getClass().getResource("/zombie.png"));
                 g.drawImage(image.getImage(),fixy, fixx,null); 
				}
				
				if(B.getB()[i][j] instanceof Plant)
				{
					int fixx =(i*squareW)+75;
		        	int fixy = (j*squareH)+65 ;
			    ImageIcon image;                
			    image=new ImageIcon(getClass().getResource("/plant.png"));
                 g.drawImage(image.getImage(),fixy, fixx, null); 
				}
				
				
				
				}
			
		}
			
	}
	
	private void gameRender() {
	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.RED);
		g.fillRect(0, squareY, squareX, B.width*100);
	
		g.setColor(new Color(218,165,32));
		g.fillRect(squareX, squareY, B.height*100, B.width*100);
		   
		
		for(int i=0; i<B.height*100; i+=squareW*2)
	        {
	        	for (int j=0; j<B.width*100; j+=squareH*2)
	        	{
	        		g.fillRect(squareX+i,squareY+j,squareW,squareH);
	        		g.fillRect(squareX+squareW+i,squareY+squareH+j,squareW,squareH);
	        	}
	        }
	    g.setColor(Color.GREEN.darker().darker());
	        for(int i=0; i<B.height*100; i+=squareW*2)
	        {
	        	for (int j=0; j<B.width*100; j+=squareH*2)
	        	{
	        		g.fillRect(squareX+i,squareY+j,squareW,squareH);
	        		g.fillRect(squareX+squareW+i,squareY+squareH+j,squareW,squareH);
	        	}
	        }
	        
	        

		
		visualize();

			
	

		//Game text
		g.setColor(Color.BLACK);
		Font f = new Font("Calibri", Font.BOLD, 72);
		g.setFont(f);
		g.drawString("Zombies vs. Plants", 380, 70);
		f = new Font("Helvetica", Font.BOLD, 24);
		
		g.setFont(f);
		g.drawString("A totally accurate simulation of home invading zombies!", 390, 100);
		g.setFont(f);
		g.drawString("Player health: " + B.getPlayerHealth(), 60, 80);
		
		   
        
		
	}
	
	private void gameDraw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	
	//-------------------- MOUSE LISTENING -----------------//
	static boolean dragging = false;
	static boolean click = false;
	static int cursorX = 0;
	static int cursorY = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		click = true;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		dragging = true;
		cursorX = e.getX();
		cursorY = e.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		dragging = false;
		click = false;
		cursorX = e.getX();
		cursorY = e.getY();
	}
	
	
	
	//EMPTY FUNCTIONS
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
}



