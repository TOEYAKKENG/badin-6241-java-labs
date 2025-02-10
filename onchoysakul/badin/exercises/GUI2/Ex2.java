package onchoysakul.badin.exercises.GUI2;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Ex2 extends JPanel {
    final private int circle_x = 10;
    final private int circle_y = 10;
    final private int circle_width = 100;
    final private int circle_height = 100;
    final private int square_width = 10;
    final private int square_height = 10;
    final private int stroke_width = 2;

    
    // Circle with radius 50 (diameter = 100)
    private Ellipse2D.Double circle = new Ellipse2D.Double(circle_x,circle_y,circle_width,circle_height);

    // Square with width & height 10
    private Rectangle2D.Double square = new Rectangle2D.Double(circle_x + circle_width /2 - square_width/2,circle_y + circle_width/2 - square_width/2,square_width,square_height);
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(stroke_width));
        g2d.draw(circle);
        g2d.setColor(Color.BLUE);
        g2d.fill(square);
    
    }
    public static void setFrameFeatures(){
        JFrame frame = new JFrame("673040624-1");
        Ex2 panel = new Ex2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100,150);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        setFrameFeatures();
        
    }
}
