import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoToCenter {
  public static void mainDraw(Graphics graphics) {
    centerFunction(graphics);
  }

  public static void centerFunction(Graphics drawingCentre) {
    int startX = 100;
    int startY = 100;
    int endX = 160;
    int endY = 160;
    drawingCentre.drawLine(startX, startY, endX, endY);
    for (int i = 0; i < 3; i++) {
      drawingCentre.drawLine(startX, startY, endX, endY);
      startX += 99;
    }
  }


  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

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