import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class GraphicsPanel extends JPanel {


	    private int squareX = 50;
	    private int squareY= 50;
	    private int squareW = 100;
	    private int squareH = 100;

	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
	        g.setColor(Color.GREEN);
	        for(int i=0; i<1000; i+=200)
	        {
	        	for (int j=0; j<600; j+=200)
	        	{
	        g.fillRect(squareX+i,squareY+j,squareW,squareH);
	        g.fillRect(squareX+100+i,squareY+100+j,squareW,squareH);
	        	}
	        }
	        g.setColor(Color.GREEN.darker().darker());
	        for(int i=0; i<1000; i+=200)
	        {
	        	for (int j=0; j<600; j+=200)
	        	{
	        g.fillRect(squareX+100+i,squareY+j,squareW,squareH);
	        g.fillRect(squareX+i,squareY+100+j,squareW,squareH);
	        	}
	        }
	        
	        g.setColor(Color.PINK);
	        g.fillOval(150, 800, 80, 80); 

	        g.setColor(Color.BLUE);
	        g.fillOval(250, 800, 80, 80); 

}
}