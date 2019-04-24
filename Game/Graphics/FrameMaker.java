import javax.swing.JFrame;

public class FrameMaker {
public static void main(String[] args) throws Exception {
JFrame frame = new JFrame();
frame.setSize(1300, 1000);
frame.setLocation(50, 100);
frame.setTitle("Battlefield");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
GraphicsPanel panel = new GraphicsPanel();
frame.add(panel);

frame.setVisible(true);
}
}