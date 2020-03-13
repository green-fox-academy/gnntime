import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
    public static void mainDraw(Graphics graphics) {

        // Draw a box that has different colored lines on each edge.
        graphics.setColor(Color.BLACK);
        graphics.drawLine(100, 100, 300, 100);
        graphics.setColor(Color.BLUE);
        graphics.drawLine(300, 100, 300, 300);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(300, 300, 100, 300);
        graphics.setColor(Color.RED);
        graphics.drawLine(100, 300, 100, 100);

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