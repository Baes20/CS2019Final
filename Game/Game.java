 package CS2019Final;

 import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class Game {

	public static void main(String[] args) {
		
		//JFrame tutorial = new JFrame();

		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		window.setTitle("zombies vs. plants");
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
		
		
	    

		
	}
	

		}
	