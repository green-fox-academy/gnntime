import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LineInTheMiddle {
  public static void mainDraw(Graphics graphics) {
    // draw a red horizontal line to the canvas' middle.
    graphics.setColor(new Color(0, 0, 0));
    graphics.drawLine(0, WIDTH / 2, WIDTH, HEIGHT / 2);

    // draw a green vertical line to the canvas' middle.
    graphics.setColor(new Color(0, 255, 0));
    graphics.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);


  }

  // Don't touch the code below
  static int WIDTH = 400;
  static int HEIGHT = 400;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}