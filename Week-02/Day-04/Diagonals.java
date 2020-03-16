import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Diagonals {
  public static void mainDraw(Graphics graphics) {
    // Draw the canvas' diagonals.
    // If it starts from the upper-left corner it should be green, otherwise it should be red.

    int startX = 0;
    int startY = 0;

    int[] start = {0, 320};
    for (int i = 0; i < start.length; i++) {
      for (int j = 0; j < start.length; j++) {
        startX = start[i];
        startY = start[j];
        if ((startX == 0) && (startY == 0)) {
          graphics.setColor(Color.RED);
          graphics.drawLine(startX, startY, 320, 320);
        } else {
          graphics.setColor(Color.GREEN);
          graphics.drawLine(startX, startY, 320, 0);
        }
      }
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