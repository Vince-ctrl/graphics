import javax.swing.*;
import java.awt.*;

// Main class to launch the window
public class BobbyBob {
    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Mr. Bob");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Add our custom drawing panel
        frame.add(new FacePanel());

        // Make the window visible
        frame.setVisible(true);
    }
}

// Custom JPanel that handles drawing the cartoon face
class FacePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Enable better graphics (anti-aliasing)
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw face outline (a big oval)
        g2.setColor(new Color(255, 220, 180)); // skin tone
        g2.fillOval(100, 50, 200, 250);

        // Draw eyes (white ovals with black pupils)
        g2.setColor(Color.WHITE);
        g2.fillOval(140, 120, 30, 20); // left eye
        g2.fillOval(230, 120, 30, 20); // right eye

        g2.setColor(Color.BLACK);
        g2.fillOval(150, 125, 10, 10); // left pupil
        g2.fillOval(240, 125, 10, 10); // right pupil

        // Draw eyebrows
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(135, 110, 170, 110); // left eyebrow
        g2.drawLine(225, 110, 260, 110); // right eyebrow

        // Draw nose (simple triangle)
        Polygon nose = new Polygon();
        nose.addPoint(195, 140);
        nose.addPoint(205, 140);
        nose.addPoint(200, 160);
        g2.setColor(new Color(240, 190, 150));
        g2.fillPolygon(nose);

        // Draw mouth (smiling arc)
        g2.setColor(Color.RED);
        g2.drawArc(160, 190, 80, 40, 0, -180); // smile

        // Optional: draw ears
        g2.setColor(new Color(255, 220, 180));
        g2.fillOval(85, 130, 20, 40); // left ear
        g2.fillOval(295, 130, 20, 40); // right ear

        // Optional: draw hair (simple black arc)
        g2.setColor(Color.BLACK);
        g2.fillArc(100, 30, 200, 100, 0, 180);
    }
}